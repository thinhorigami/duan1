package com.nhom2.duan1.repository;

import com.nhom2.duan1.model.NhanVien;
import com.nhom2.duan1.utilities.lib.DataConnect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.nhom2.duan1.utilities.lib.annotation.data.DataField;
import com.nhom2.duan1.utilities.lib.annotation.data.DataTable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class NhanvienRepository {

    private DataConnect data_connect;
    private String table;
    private List<String> fields;

    public NhanvienRepository() throws SQLException {
        this.data_connect = new DataConnect();
        this.table = NhanVien.class.getAnnotation(DataTable.class).name();
        this.fields = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .map((o) -> (o.getAnnotation(DataField.class).name()))
                .collect(Collectors.toList());
    }

    public String generateSelectAllQuery() {

        StringBuilder sb = new StringBuilder(" SELECT ");
        for (int i = 0; i < fields.size() - 1; ++i) {
            sb.append(table + "." + fields.get(i));
            sb.append(",\n");
        }
        sb.append(table + "." + fields.get(fields.size() - 1));

        sb.append(new String(" FROM ")
                .concat(table));

        return sb.toString();
    }

    public Optional<NhanVien> mapp(ResultSet _result) throws SQLException, IllegalArgumentException, IllegalAccessException {
        NhanVien opt = new NhanVien();

        List<Field> f = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .collect(Collectors.toList());

        for (Field i : f) {
            i.setAccessible(true);
            i.set(opt, _result.getObject(i.getAnnotation(DataField.class).name()));
            i.setAccessible(false);
        }
        return Optional.ofNullable(opt);
    }

    public List<NhanVien> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException {
        ArrayList<NhanVien> ret = new ArrayList<>();
        String query = this.generateSelectAllQuery();
        PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
        ResultSet r = s.executeQuery();
        Optional<NhanVien> o;
        while (r.next()) {
            o = this.mapp(r);
            if (o.isPresent()) {
                ret.add(o.get());
            }
        }
        return ret;
    }
}
