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
import view.TestForgotPasswordPanel;
import view.ViewForgotPassword;

/**
 *
 * @author nguye
 */
public class TestForgotPassword {
    public static void main(String[] args) throws SQLException, InterruptedException {
        var f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 500, 500);
        f.setLayout(new MigLayout());
        f.setBackground(Color.white);
        f.add(new TestForgotPasswordPanel(), "pos 0 0 100% 100%");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
