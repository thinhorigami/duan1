/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import view.login.swing.MyPasswordField;
import view.login.swing.MyTextField;
import view.login.swing.Button;

import Domainmodel.NhanVien;
import Repositories.ChucVuRepository;

import ServiceImpl.NhanVienServiceImpl;
import Utilities.MailVerificate;
import Utilities.VietNamPattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import org.apache.commons.lang.Validate;
import Utilities.SendMail;
import com.github.lgooddatepicker.components.DatePicker;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JPasswordField;
import view.login.swing.ValidateTextField;

/**
 *
 * @author thinhorigami
 */
public class Register extends javax.swing.JPanel {

    private ValidateTextField full_name,
            email,
            address,
            phone_number;
    
    private DatePicker birth;
    private JPasswordField password, confirm_password;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private JButton register_button;

    private NhanVienServiceImpl service;

    private MailVerificate mail_verificate;
    private SendMail send_mail;

    /**
     * Creates new form Register
     */
    public Register() throws SQLException {
        initComponents();
        this.send_mail = new SendMail();
        this.send_mail.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
        this.setBackground(Color.WHITE);
        this.service = new NhanVienServiceImpl();
        this.mail_verificate = new MailVerificate();
        init();
    }

    public Register(int _width, int _height) throws SQLException {
        this();
        this.setSize(_width, _height);
    }

    public Register(Dimension _d) throws SQLException {
        this(_d.width, _d.height);
    }

    public void init() {
        this.setLayout(new MigLayout("wrap", "push[center]push"));

        System.out.println(this.getClass().getClassLoader().getResource("").toString());

        JLabel label = new JLabel("Sign Up");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        this.add(label, "W 60%");

        
        full_name = new ValidateTextField(VietNamPattern.TEN, "tên không hợp lệ", new JLabel());
        this.add(new JLabel("họ tên"), "al left");
        this.add(full_name.getLabel());
        this.add(full_name, "W 60%");

        email = new ValidateTextField("[a-zA-Z0-9 .]+@[a-z.]+", "email không hợp lệ", new JLabel());
        this.add(new JLabel( "nhập email"), "al left");
        this.add(email, "W 60%");
        this.add(email.getLabel());

        male = new JRadioButton("nam");
        male.setSelected(true);
        female = new JRadioButton("nữ");
        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        this.add(new JLabel("giới tính"), "al left");
        this.add(male, "al left, split2");
        this.add(female, "");

        this.address = new ValidateTextField(VietNamPattern.DIA_CHI, "địa chỉ không hợp lệ", new JLabel());
        this.add(new JLabel("địa chỉ"),"al left");
        this.add(address, "W 60%");
        this.add(this.address.getLabel());
        
        phone_number = new ValidateTextField("[0-9]+", "số điện thoại không hợp lệ", new JLabel());
        this.add(new JLabel("số điện thoại"), "al left");
        this.add(phone_number, "W 60%");
        this.add(phone_number.getLabel());

        birth = new DatePicker();
        this.add(birth, "W 60%");

        password = new JPasswordField();
        this.add(new JLabel("mật khẩu"), "al left");
        this.add(password, "W 60%");

        confirm_password = new JPasswordField();
        this.add(new JLabel("xác nhận mật khẩu"), "al left");
        this.add(confirm_password, "W 60%");
        
        register_button = new Button();
        register_button.setBackground(new Color(7, 164, 121));
        register_button.setForeground(new Color(250, 250, 250));
        register_button.setText("Sign Up");
        register_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                register_button.setEnabled(false);
                NhanVien nv = new NhanVien();
                nv.setMa(UUID.randomUUID().toString().substring(0, 9));

                nv.setTen(full_name.getText().trim());
                nv.setEmail(email.getText().trim());
                nv.setDiaChi(address.getText().trim());
                nv.setGioiTinh(male.isSelected() ? "Nam" : "Nu");
                nv.setDienThoai(phone_number.getText().trim());

                Date date = Date.from(birth.getDate()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant());

                nv.setNgaySinh(date);
                if (new String(password.getPassword()).equals(new String(confirm_password.getPassword()))) {
                    nv.setMatKhau(new String(password.getPassword()));
                } else {
                    JOptionPane.showMessageDialog(null, "mật khẩu và xác nhận mật khẩu không khớp");
                    register_button.setEnabled(true);
                    return;
                }

                // đang hoạt động
                nv.setTrangThai(1);

                try {
                    new ChucVuRepository().getByTenChucVu("nhân viên").ifPresentOrElse((o) -> {
                        nv.setIdChaucVu(o.getId());
                    }, () -> {
                        // maybe
                        JOptionPane.showMessageDialog(null, "SYS-ERROR! không tìm thấy chức vụ trong DB");
                    });
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    service.exists(nv).ifPresentOrElse((o) -> {
                        // tồn tại -> không được đăng ký
                        JOptionPane.showMessageDialog(null, "email hoặc số điện thoại đã tồn tại");
                    }, () -> {
                        // không tồn tại -> được đăng ký
                        // các thực mail trước khi ínert
                        long code = new Date().getTime() % 100000;
                        
                        var send_mail_th = new Thread() {
                            @Override
                            public void run() {
                                send_mail.send(nv.getEmail(), "Verification Code", code + "");
                            }
                        };
//                        send_mail_th.start();
                        try {
                            send_mail_th.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        if (send_mail.isResult()) {
                            if (mail_verificate.isResult()) {
                                JOptionPane.showMessageDialog(null, "xác thực email " + nv.getEmail() + "thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "xác thực email " + nv.getEmail() + "thất bại");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "không thể gửi mã xác thực đến email " + nv.getEmail());
                        }
                        
                        if (mail_verificate.isResult()) {
                            service.insert(nv).ifPresentOrElse((o) -> {
                                JOptionPane.showMessageDialog(null, "đăng kí thành công");
                            }, () -> {
                                JOptionPane.showMessageDialog(null, "đăng kí thất bại");
                            });
                        }
                    });

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(register_button, "W 60%, h 40");

        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
