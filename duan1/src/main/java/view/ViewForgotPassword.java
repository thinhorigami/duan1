/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Domainmodel.NhanVien;
import Service.NhanVienService;
import ServiceImpl.NhanVienServiceImpl;
import Utilities.MailVerificate;
import Utilities.SendMail;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.tools.ant.taskdefs.SendEmail;

/**
 *
 * @author tuphph24187
 */
public class ViewForgotPassword extends javax.swing.JFrame {

    private NhanVienService service;
    private SendMail send_mail;
    private MailVerificate mail_verificate;

    public ViewForgotPassword() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        this.send_mail = new SendMail();
        this.send_mail.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
        this.service = new NhanVienServiceImpl();
        this.mail_verificate = new MailVerificate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        bg1 = new javax.swing.JLayeredPane();
        bg2 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGuiMatKhau = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        email_or_ma_nv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirn_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setOpaque(true);

        bg1.setOpaque(true);

        bg2.setOpaque(true);
        bg2.setPreferredSize(new java.awt.Dimension(763, 523));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 189, 164));
        jLabel2.setText("quên mật khẩu");

        btnGuiMatKhau.setBackground(new java.awt.Color(23, 192, 128));
        btnGuiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiMatKhau.setText("Gửi mật khẩu qua email đăng kí");
        btnGuiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMatKhauActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        email_or_ma_nv.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setText("email");

        jLabel3.setText("mật khẩu mới");

        jLabel4.setText("xác nhận mật khẩu mới");

        password.setText("jPasswordField1");

        confirn_password.setText("jPasswordField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnGuiMatKhau)
                                    .addGap(28, 28, 28)
                                    .addComponent(btnThoat))
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(confirn_password))
                            .addGap(30, 30, 30)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(email_or_ma_nv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(email_or_ma_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirn_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        bg2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bg2Layout = new javax.swing.GroupLayout(bg2);
        bg2.setLayout(bg2Layout);
        bg2Layout.setHorizontalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bg2Layout.setVerticalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg1.setLayer(bg2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bg1Layout = new javax.swing.GroupLayout(bg1);
        bg1.setLayout(bg1Layout);
        bg1Layout.setHorizontalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addComponent(bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bg1Layout.setVerticalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addComponent(bg2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.setLayer(bg1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMatKhauActionPerformed
        var nv_opt = service.getByEmail(email_or_ma_nv.getText());
        if (nv_opt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "email không tồn tại");
            return;
        }
        
        if (new String(password.getPassword()).compareTo(new String(confirn_password.getPassword())) == 0) {
            long code = new Date().getTime() % 100000;
            var sm = new SendMail();
            try {
                Loading sml = new Loading() {
                    @Override
                    public boolean onLoading() {
                        sm.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
                        sm.send(email_or_ma_nv.getText(), "Verification code", code + "");
                        return sm.isResult();
                    }

                    @Override
                    public void onSuccess() {
                        if (sm.isResult()) {
                            if (mail_verificate.isResult()) {
                                JOptionPane.showMessageDialog(null, "xác thực email " + email_or_ma_nv.getText() + " thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "xác thực email " + email_or_ma_nv.getText() + " thất bại");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "không thể gửi mã xác thực đến email " + email_or_ma_nv.getText());
                        }

                        if (mail_verificate.isResult()) {
                            try {
                                service.forgotPassword(nv_opt.get(), new String(password.getPassword()))
                                        .ifPresentOrElse((o) -> {
                                    JOptionPane.showMessageDialog(null, "đổi mâtj khẩu thành công");
                                }, () -> {
                                    JOptionPane.showMessageDialog(null, "đổi mật khẩu thất bại");
                                });
                            } catch (SQLException ex) {
                                Logger.getLogger(ViewForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println("success");
                    }

                    @Override
                    public void onFailed() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                sml.Start();
                add(sml, "pos 0 0 100% 100%");
            } catch (InterruptedException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "mật khẩu mới và xác nhận mật khẩu mới không giống nhau");
        }
    }//GEN-LAST:event_btnGuiMatKhauActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.setVisible(false);
        try {
            new ViewLogin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ViewForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewForgotPassword().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JLayeredPane bg1;
    private javax.swing.JLayeredPane bg2;
    private javax.swing.JButton btnGuiMatKhau;
    private javax.swing.JButton btnThoat;
    private javax.swing.JPasswordField confirn_password;
    private javax.swing.JTextField email_or_ma_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
