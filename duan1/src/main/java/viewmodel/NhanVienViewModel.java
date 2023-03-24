/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Domainmodel.NhanVien;
import Utilities.annotation.SwingTable;
import Utilities.annotation.SwingTableHeader;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class NhanVienViewModel extends JTable {
    
    public NhanVienViewModel() throws SQLException {
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
        
        // @TableHeader.name() is header of column
        DefaultTableModel model = (DefaultTableModel)this.getModel();
        this.getTableHeader().setBackground(Color.decode("#95BDFF"));
//        model.setRowCount(4);
        for (String name: fields) model.addColumn(name);
    }
}
