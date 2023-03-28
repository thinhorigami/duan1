/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.Register;
import view.WebCamView;

/**
 *
 * @author nguye
 */
public class TestDangKy {
        public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(1, 0, 500, 500);
        
        f.add(new Register());
        f.setVisible(true);
    }
}
