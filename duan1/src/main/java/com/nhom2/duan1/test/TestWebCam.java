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
import view.WebCamView;

/**
 *
 * @author nguye
 */
public class TestWebCam {
    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(1, 0, 500, 500);
        WebCamView wc = new WebCamView(f, true);
        JButton b = new JButton("click me");
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                wc.setVisible(true);
                System.out.println("hehe");
            }
        });
        
        f.add(b);
        f.setVisible(true);
    }
}
