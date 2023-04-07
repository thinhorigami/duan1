/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Service.NhanVienService;
import ServiceImpl.NhanVienServiceImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import view.login.swing.Button;
import view.login.swing.ValidatePassword;
import view.login.swing.ValidateTextField;

/**
 *
 * @author nguye
 */
public abstract class Login extends JPanel {

  private NhanVienService service;
  private ValidateTextField email;
  private ValidatePassword password;
  private Button login;
  private JLabel forgot_password, register;

  public Login() throws SQLException {
    this.service = new NhanVienServiceImpl();
    this.setLayout(new MigLayout("wrap", "push[center]push"));
    JLabel label = new JLabel("Đăng nhập");
    label.setFont(new Font("sansserif", 1, 30));
    label.setForeground(new Color(7, 164, 121));
    this.add(label, "W 50%");

    this.add(new JLabel("email"), " wrap, al left");
    this.email = new ValidateTextField("^[a-zA-Z0-9.]+@[a-zA-Z.]+$", "email không hợp lệ", new JLabel());
    this.add(email, "W 50%");
    this.add(email.getLabel(), "wrap, al left");

    this.add(new JLabel("mật khẩu"), "wrap, al left");
    this.password = new ValidatePassword();
    this.add(password, "wrap, W 50%");
    this.add(password.getLabel());
    
    forgot_password = new JLabel("quên mật khẩu");
    forgot_password.setForeground(Color.BLUE);
    this.add(forgot_password, "wrap, W 50%");

    login = new Button("đăng nhập");
    login.setBackground(new Color(7, 164, 121));
    login.setForeground(new Color(250, 250, 250));
    this.add(login, "wrap, W 50%");
    login.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (!email.isResult() && !password.isResult()) {
          JOptionPane.showMessageDialog(null, "email hoặc mệt khẩu không hợp lệ");
        } 
      }
    });

    register = new JLabel("đăng ký");
    register.setForeground(Color.BLUE);
    this.add(register, "wrap, W 50%");

  }

  public abstract void showRegister();

  public abstract void showForgotPassword();
}
