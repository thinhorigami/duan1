/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.login.swing;

import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.nhom2.duan1.utilities.lib.annotation.SwingTable;
import com.nhom2.duan1.utilities.lib.annotation.SwingTableHeader;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author thinhorigami
 */
public class MyTable<TData, TControl extends JPanel> extends JTable {
    
    private Class<TData> data;
    private Class<TControl> control;
    
    public MyTable(Class<TData> _data, Class<TControl> _control) throws Exception {
        this.data = _data;
        this.control = _control;
        init(this.data, this.control);
    }
    
    public void init(Class<TData> _data, Class<TControl> _control) throws Exception {
        
        // TData contraint @Table
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
        System.out.println(model.getColumnCount());
    }
    
    public void fillData(List<TData> _data) throws IllegalArgumentException, IllegalAccessException, IllegalAccessException {
        
        DefaultTableModel model = (DefaultTableModel)this.getModel();
        
        List<Field> f = Arrays.asList(this.data.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(SwingTableHeader.class)))
                .collect(Collectors.toList());
        
        List<String> row_data = new ArrayList<>();
        
        for (TData i: _data) {
            row_data = new ArrayList<>();
            for (Field j: f) {
                j.setAccessible(true);
                row_data.add(j.get(i).toString());
                System.out.println(j.get(i).toString());
            }
            model.addRow(row_data.toArray());
        }
    }
}
