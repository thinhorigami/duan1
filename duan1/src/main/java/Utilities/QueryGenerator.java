/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Domainmodel.NhanVien;
import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.math3.stat.inference.TTest;

/**
 *
 * @author nguye
 */
public class QueryGenerator<TTable extends Object> {

    private String table_namw;
    private List<String> fields;
    private Class<?> table;

    public QueryGenerator(Class<TTable> _table) {
        this.table = _table;
        this.table_namw = this.table.getAnnotation(DataTable.class).name();
        this.fields = Arrays.asList(this.table.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .map((o) -> (o.getAnnotation(DataField.class).name()))
                .collect(Collectors.toList());
    }

    public Optional<TTable> mapp(ResultSet _result, TTable result_value) throws SQLException, IllegalArgumentException, IllegalAccessException {
        List<Field> f = Arrays.asList(this.table.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .collect(Collectors.toList());

        for (Field i : f) {
            i.setAccessible(true);
            i.set(result_value, _result.getObject(i.getAnnotation(DataField.class).name()));
            i.setAccessible(false);
        }
        return Optional.ofNullable(result_value);
    }
    
    public String generateSelectAllQuery() {

        StringBuilder sb = new StringBuilder(" SELECT ");
        for (int i = 0; i < fields.size() - 1; ++i) {
            sb.append(table_namw + "." + fields.get(i));
            sb.append(",\n");
        }
        sb.append(table_namw + "." + fields.get(fields.size() - 1));

        sb.append(new String(" FROM ")
                .concat(table_namw));

        return sb.toString();
    }

    public String generateInsertQuery() {
        StringBuilder sb = new StringBuilder(" INSERT INTO " + table_namw);
        sb.append(" ( ");
        for (int i = 0; i < this.fields.size() - 1; ++i) {
            sb.append(this.fields.get(i) + ", ");
        }
        sb.append(this.fields.get(this.fields.size() - 1));
        sb.append(" ) ");
        sb.append(" VALUES (");
        for (int i = 0; i < this.fields.size(); ++i) {
            sb.append(" ? ");
            if (i < this.fields.size() - 1) {
                sb.append(" , ");
            }
        }
        sb.append(" ) ");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String generateUpdateQuery() {

        StringBuilder sb = new StringBuilder(" UPDATE " + table + " ");
        sb.append(" SET ");

        for (int i = 0; i < this.fields.size(); ++i) {
            sb.append(this.fields.get(i) + " = ?");

            if (i < this.fields.size() - 1) {
                sb.append(" , ");
            }
        }

        sb.append(" WHERE " + this.fields.get(0) + " = ?");
        return sb.toString();
    }
}
