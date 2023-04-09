/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.Loading;
import view.Register;

/**
 *
 * @author nguye
 */
public class TestDangKy {

    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(1, 0, 500, 550);

        f.add(new Register() {
          @Override
          public void onLogin() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          }
        });
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
