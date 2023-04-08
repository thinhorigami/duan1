/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Domainmodel.NhanVien;
import Service.NhanVienService;
import ServiceImpl.NhanVienServiceImpl;
import Utilities.MailVerificate;
import Utilities.SendMail;
import Utilities.VietNamPattern;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import view.login.swing.Button;
import view.login.swing.MyTextField;
import view.login.swing.ValidatePassword;
import view.login.swing.ValidateTextField;

/**
 *
 * @author nguye
 */
public abstract class TestForgotPasswordPanel extends JLayeredPane {
    private ValidateTextField email;
    private ValidatePassword password, confirn_password;
    private Button fogot_password, cancel;
    private NhanVienService service;
    private Loading sml;
    private long code;
    private MailVerificate mail_verificate;
    private Optional<NhanVien> nv_opt;

    public TestForgotPasswordPanel() throws SQLException, InterruptedException {
        this.setBackground(Color.WHITE);
        this.service = new NhanVienServiceImpl();
        this.code = 0; // default
        this.mail_verificate = new MailVerificate();
        this.nv_opt = Optional.empty(); // default

        this.sml = new Loading() {
            @Override
            public boolean onLoading() {
                code = new Random().ints(100000, 999999)
                        .findFirst()
                        .getAsInt();
                var sm = new SendMail();
                sm.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
                sm.send(email.getText(), "Verification code", code + "");
                return sm.isResult();
            }

            @Override
            public void onSuccess() {
                try {
                    mail_verificate.Verficate(code);
                    if (mail_verificate.isResult()) {
                        JOptionPane.showMessageDialog(null, "xác thực email " + email.getText() + " thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "xác thực email " + email.getText() + " thất bại");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestForgotPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (mail_verificate.isResult()) {
                    try {
                        service.forgotPassword(nv_opt.get(), new String(password.getPassword()))
                                .ifPresentOrElse((o) -> {
                                    JOptionPane.showMessageDialog(null, "đổi mật khẩu thành công");
                                }, () -> {
                                    JOptionPane.showMessageDialog(null, "đổi mật khẩu thất bại");
                                });
                    } catch (SQLException ex) {
                        Logger.getLogger(TestForgotPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("success");
            }

            @Override
            public void onFailed() {
                JOptionPane.showMessageDialog(null, "không thể gửi mã xác nhận đếm email " + email.getText());
            }
        };

        this.setLayout(new MigLayout("wrap", "push[center]push"));
        JLabel label = new JLabel("Đổi mật khẩu");
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
        this.add(password.getLabel(), "wrap, al left");
        
        this.add(new JLabel("xác nhận mật khẩu"), "wrap, al left");
        this.confirn_password = new ValidatePassword();
        this.add(confirn_password, "wrap, W 50%");
        this.add(confirn_password.getLabel(), "wrap, al left");
        
        this.fogot_password = new Button("tiếp tục");
        fogot_password.setBackground(new Color(7, 164, 121));
        fogot_password.setForeground(new Color(250, 250, 250));
        this.add(this.fogot_password, "split2, al left, W 25%");

        this.cancel = new Button("hủy");
        cancel.setBackground(new Color(7, 164, 121));
        cancel.setForeground(new Color(250, 250, 250));
        this.add(this.cancel, "al right, W 25%");
        cancel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            onCancel();
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
          }
        });

        setLayer(sml, JLayeredPane.POPUP_LAYER);
        add(sml, "pos 0 0 100% 100%");
        sml.setVisible(false);
        this.fogot_password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nv_opt = service.getByEmail(email.getText());
                if (nv_opt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "email không tồn tại");
                    return;
                }

                if (new String(password.getPassword())
                        .compareTo(new String(confirn_password.getPassword())) == 0) {

                    try {
                        sml.setVisible(true);
                        sml.Start();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestForgotPasswordPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "mật khẩu mới và xác nhận mật khẩu mới không khớp");
                }
            }
        });
    }
    
    public abstract void onCancel();
}
