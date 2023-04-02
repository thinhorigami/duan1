/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Domainmodel.ChucVu;
import Domainmodel.NhanVien;
import Service.ChucVuService;
import Service.NhanVienService;
import ServiceImpl.ChucVuServiceImpl;
import ServiceImpl.NhanVienServiceImpl;
import Utilities.annotation.SwingTable;
import Utilities.annotation.SwingTableHeader;
import java.awt.Color;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class NhanVienViewModel extends JTable {

    private NhanVienService nhan_vien;

    public NhanVienViewModel() throws SQLException, Exception {
        this.nhan_vien = new NhanVienServiceImpl();
        init(NhanVien.class);
    }

    public void init(Class<NhanVien> _data) throws Exception {
        if (!_data.isAnnotationPresent(SwingTable.class)) {
            throw new Exception(
                    _data.getName() + " mot has " + SwingTable.class.getName());
        }

        List<String> fields = Arrays.stream(_data.getDeclaredFields())
                .filter((arg) -> (arg.isAnnotationPresent(SwingTableHeader.class)))
                .map((arg) -> (arg.getAnnotation(SwingTableHeader.class).name()))
                .toList();
        
        String chuc_vu_field = Arrays.asList(ChucVu.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(SwingTableHeader.class)))
                .findFirst()
                .get().getAnnotation(SwingTableHeader.class)
                .name();

        // @TableHeader.name() is header of column
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        this.getTableHeader().setBackground(Color.decode("#95BDFF"));
//        model.setRowCount(4);
        for (String name : fields) {
            model.addColumn(name);
        }
        model.addColumn(chuc_vu_field);
    }

    public void fillData(List<NhanVien> _data) throws IllegalArgumentException, IllegalAccessException, IllegalAccessException {

        DefaultTableModel model = (DefaultTableModel) this.getModel();

        List<Field> f = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(SwingTableHeader.class)))
                .collect(Collectors.toList());

        List<String> row_data = new ArrayList<>();
        
        var tt = new HashMap<String, String>() {{
            put("1", "đang hoạt động");
            put("0", "không còn hoạt động");
        }};
        
        for (NhanVien i : _data) {
            row_data = new ArrayList<>();
            for (Field j : f) {
                j.setAccessible(true);
                
                if (j.getAnnotation(SwingTableHeader.class).name()
                        .compareTo("trạng thái") == 0) {
                    row_data.add(tt.get(j.get(i).toString()));
                }
                else {
                    row_data.add(j.get(i).toString());
                }
                System.out.println(j.get(i).toString());
            }
            var cv = this.nhan_vien.getChucVu(i);
            if (cv.isEmpty()) return;
            row_data.add(cv.get().getTen());
            model.addRow(row_data.toArray());
        }
    }
}
