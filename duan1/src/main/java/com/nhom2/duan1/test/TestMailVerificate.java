/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import Utilities.MailVerificate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.login.swing.Button;

/**
 *
 * @author nguye
 */
public class TestMailVerificate {

    public static void main(String[] args) {
        var f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 400, 400);
        f.setLayout(new MigLayout());
        var b = new Button();
        var d = new MailVerificate();
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                d.setModal(true);
                try {
                    d.Verficate(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestMailVerificate.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(d.isResult());
            }
        });
        
        f.add(b, "W 100%");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
