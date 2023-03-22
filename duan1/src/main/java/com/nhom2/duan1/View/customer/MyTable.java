/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.View.customer;

import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.nhom2.duan1.utilities.lib.annotation.SwingTable;
import com.nhom2.duan1.utilities.lib.annotation.SwingTableHeader;
import java.awt.Color;

/**
 *
 * @author thinhorigami
 */
public class MyTable<TData, TControl extends JPanel> extends JTable {
    
    public MyTable(Class<TData> _data, Class<TControl> _control) throws Exception {
        init(_data, _control);
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
        model.setRowCount(4);;
        for (String name: fields) model.addColumn(name);
        System.out.println(model.getColumnCount());
    }
}
