/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.Login;
import view.TestForgotPasswordPanel;
import view.ViewLogin;

/**
 *
 * @author nguye
 */
public class TestLogin {
    public static void main(String[] args) throws SQLException, Exception {
        var f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 500, 300);
        f.setLayout(new MigLayout());
        f.setBackground(Color.white);
        f.add(new Login() {
          @Override
          public void showRegister() {
            
          }

          @Override
          public void showForgotPassword() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          }
        }, "pos 0 0 100% 100%");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
