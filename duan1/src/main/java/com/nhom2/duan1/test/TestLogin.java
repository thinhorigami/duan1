/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import Domainmodel.NhanVien;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.FormTrangChu;
import view.Login;
import view.Register;
import view.TestForgotPasswordPanel;
import view.ViewLogin;

/**
 *
 * @author nguye
 */
public class TestLogin extends JFrame {
  
  public Login login;
  public Register register;
  public TestForgotPasswordPanel forgot_password;
  
  public void init() throws SQLException, InterruptedException {
    
    setResizable(true);
    
    setLayout(new MigLayout());
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(0, 0, 500, 300);
    setLayout(new MigLayout());
    setBackground(Color.white);
    
    forgot_password = new TestForgotPasswordPanel() {
      @Override
      public void onCancel() {
        onLogin();
      }

      @Override
      public void onLogin() {
        setSize(500, 350);
        this.setVisible(false);
        login.setVisible(true);
        onResize(500, 300);
        setLocationRelativeTo(null);
      }
    };
    
    register = new Register();
    
    login = new Login() {
      @Override
      public void onForgotPassword() {
        setSize(forgot_password.getSize());
        this.setVisible(false);
        forgot_password.setVisible(true);
        setLocationRelativeTo(null);
      }

      @Override
      public void onSuccess(NhanVien _nv) {
        try {
          new FormTrangChu().setVisible(true);
        } catch (SQLException ex) {
          Logger.getLogger(TestLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    };
    
    add(login, "pos 0 0 100% 100%");
    add(register, "pos 0 0 100% 100%");
    register.setVisible(false);
    
    add(forgot_password, "pos 0 0 100% 100%");
    forgot_password.setVisible(false);
    setLocationRelativeTo(null);
    setVisible(true);
    
  }
  
  public void onResize(Dimension d) {
    this.setSize(d);
  }
  
  public void onResize(int w, int h) {
    this.setSize(w, h);
  }
  
  public static void main(String[] args) throws SQLException, InterruptedException {
    var tl = new TestLogin();
    tl.init();
    tl.setVisible(true);
  }
}
