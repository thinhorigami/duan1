/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import view.ViewForgotPassword;

/**
 *
 * @author nguye
 */
public class TestForgotPassword {
    public static void main(String[] args) {
        var f = new JFrame();
        f.setLayout(new MigLayout());
        var fp = new ViewForgotPassword();
        f.add(fp, "W 50%");
        f.setVisible(true);
    }
}
