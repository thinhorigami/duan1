/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import Utilities.MailVerificate;
import Utilities.SendMail;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.Loading;

/**
 *
 * @author nguye
 */
public class TestLoading {
    public static void main(String[] args) throws InterruptedException {
        var f = new JFrame();
        var l = new JLayeredPane();
        var loading = new Loading() {
            @Override
            public boolean onLoading() {
                var send_mail = new SendMail();
                send_mail.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
                send_mail.send("thinhntph24396@fpt.edu.vn", "hi", "chào cậu");
                System.out.println(send_mail.isResult());
                return send_mail.isResult();
            }

            @Override
            public void onSuccess() {
                try {
                    new MailVerificate().Verficate(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestLoading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onFailed() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 500, 500);
        f.setLayout(new MigLayout());
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        l.add(loading, JLayeredPane.POPUP_LAYER);
        f.add(l, "pos 0 0 100% 100%");
        f.add(loading, "pos 0 0 100% 100%");
        loading.Start();
    }
}
