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

public class NhanvienRepository {

    private DataConnect data_connect;

    public NhanvienRepository() throws SQLException {
//        this.data_connect = new DataConnect();
    }
    
    public String generateSelectQuery() {
        
        String table = NhanVien.class.getAnnotation(DataTable.class).name();
        List<String> fields = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .map((o) -> (o.getAnnotation(DataField.class).name()))
                .collect(Collectors.toList());
        
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

    public Iterable<NhanVien> getAll() {
        ArrayList<NhanVien> ret = new ArrayList<>();

        String query = this.generateSelectQuery();

        return (Iterable<NhanVien>) ret;
    }
}
