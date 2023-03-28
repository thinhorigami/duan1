/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.Register;
import view.ViewLogin;

/**
 *
 * @author nguye
 */
public class TestLogin {
    public static void main(String[] args) throws SQLException, Exception {
        new ViewLogin().setVisible(true);
    }
}
