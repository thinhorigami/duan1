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
import java.util.Optional;
import java.util.Random;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.login.swing.ValidateTextField;

/**
 *
 * @author thinhorigami
 */
public abstract class Register extends javax.swing.JLayeredPane {

    private ValidateTextField full_name,
            email,
            address,
            phone_number;

    private DatePicker birth;
    private JPasswordField password, confirm_password;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private JButton register_button, cancel;
    private JLabel login;

    private NhanVienServiceImpl service;

    private MailVerificate mail_verificate;
    private Loading loading;
    private long code;
    private Optional<NhanVien> nv_opt;
    /**
     * Creates new form Register
     */
    public Register() throws SQLException, InterruptedException {
        initComponents();
        this.setBackground(Color.WHITE);
        this.service = new NhanVienServiceImpl();
        this.mail_verificate = new MailVerificate();
        
        this.code = 0;
        this.loading = new Loading() {
            @Override
            public boolean onLoading() {
                var sm = new SendMail();
                code = new Random().ints(100000, 999999)
                        .findFirst()
                        .getAsInt();
                sm.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
                sm.send(email.getText(), "Verification code", code + "");
                return sm.isResult();
            }

            @Override
            public void onSuccess() {
                try {
                    mail_verificate.Verficate(code);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (mail_verificate.isResult()) {
                    service.insert(nv_opt.get()).ifPresentOrElse((o) -> {
                      JOptionPane.showMessageDialog(null, "đăng ký thành công");
                    }, () -> {
                      JOptionPane.showMessageDialog(null, "đăng ký thất bại");
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "xác thực email " + nv_opt.get().getEmail() + "thất bại");
                }
            }

            @Override
            public void onFailed() {
                JOptionPane.showMessageDialog(null, "không thể giửu mã xác nhận đén email " + nv_opt.get().getEmail());
            }
        };
        this.nv_opt = Optional.empty();
        
        loading.setVisible(false);
        init();
        this.setLayer(loading, JLayeredPane.POPUP_LAYER);
        this.add(loading, "pos 0 0 100% 100%");
    }

    public Register(int _width, int _height) throws SQLException, InterruptedException {
        this();
        this.setSize(_width, _height);
    }

    public Register(Dimension _d) throws SQLException, InterruptedException {
        this(_d.width, _d.height);
    }

    public void init() {
        this.setLayout(new MigLayout("insets 0, wrap", "push[center]push"));

        System.out.println(this.getClass().getClassLoader().getResource("").toString());

        JLabel label = new JLabel("Đăng ký");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        this.add(label, "W 60%");

        full_name = new ValidateTextField(VietNamPattern.TEN, "tên không hợp lệ", new JLabel());
        this.add(new JLabel("họ tên"), "al left");
        this.add(full_name.getLabel());
        this.add(full_name, "W 60%");

        email = new ValidateTextField("[a-zA-Z0-9 .]+@[a-z.]+", "email không hợp lệ", new JLabel());
        this.add(new JLabel("email"), "al left");
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
        this.add(new JLabel("địa chỉ"), "al left");
        this.add(address, "W 60%");
        this.add(this.address.getLabel());

        phone_number = new ValidateTextField("[0-9]+", "số điện thoại không hợp lệ", new JLabel());
        this.add(new JLabel("số điện thoại"), "al left");
        this.add(phone_number, "W 60%");
        this.add(phone_number.getLabel());

        this.add(new JLabel("nhày sinh"), "W 60%");
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
        register_button.setText("Đăng ký");
        register_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // validation
                if (!(full_name.isResult()
                        && email.isResult()
                        && address.isResult()
                        && phone_number.isResult())) {
                   JOptionPane.showMessageDialog(null, "thông tin không hợp lệ");
                  return;
                }

                register_button.setEnabled(false);
                NhanVien nv = new NhanVien();
                nv.setMa(UUID.randomUUID().toString().substring(0, 8));

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
                
                nv_opt = Optional.of(nv);
                
                try {
                    service.exists(nv).ifPresentOrElse((o) -> {
                        // tồn tại -> không được đăng ký
                        JOptionPane.showMessageDialog(null, "email hoặc số điện thoại đã tồn tại");
                    }, () -> {
                        // không tồn tại -> được đăng ký
                        
                        try {
                            loading.setVisible(true);
                            loading.Start();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(register_button, "h 40, W 60%");
        
        login = new JLabel("đăng nhập");
        login.setForeground(Color.BLUE);
        login.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            onLogin();
          }
        });
        this.add(login, "al right");
        this.setVisible(true);
    }

    public abstract void onLogin();
    
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
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
