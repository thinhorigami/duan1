/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import ServiceImpl.NhanVienServiceImpl;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.NhanVienView;
import view.QuanLyNhanVien;

/**
 *
 * @author nguye
 */
public class TestQuanLyNhanvien {
    public static void main(String[] args) throws Exception {
        var f = new JFrame();
        
        f.setLayout(new MigLayout());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0,0,700,700);
        f.add(new QuanLyNhanVien());
        f.setVisible(true);
    }
}
