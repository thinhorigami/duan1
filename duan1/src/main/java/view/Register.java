/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import view.login.swing.MyPasswordField;
import view.login.swing.MyTextField;
import view.login.swing.Button;

import Domainmodel.NhanVien;

import ServiceImpl.NhanVienServiceImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author thinhorigami
 */
public class Register extends javax.swing.JPanel {

    private MyTextField full_name,
            email,
            address,
            cccd_number,
            phone_number,
            birth;
    private MyPasswordField password, confirm_password;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private MigLayout layout;
    private JButton register_button;
    
    private NhanVienServiceImpl service;
    /**
     * Creates new form Register
     */
    public Register() throws SQLException {
        initComponents();
        this.setBackground(Color.WHITE);
        this.service = new NhanVienServiceImpl();
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
        
        full_name = new MyTextField();
        full_name.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Unknown_person.png")));
        full_name.setHint("nhập họ tên");
        this.add(full_name, "W 60%");
        
        email = new MyTextField();
        email.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Mail.png")));
        email.setHint("nhập email");
        this.add(email, "W 60%");
        
        male = new JRadioButton("nam");
        female = new JRadioButton("nữ");
        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        this.add(male, "al left, split2");
        this.add(female, "");
        
        address = new MyTextField();
        address.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Home.png")));
        address.setHint("nhập địa chỉ");
        this.add(address, "W 60%");
        
        cccd_number = new MyTextField();
        cccd_number.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/User.png")));
        cccd_number.setHint("nhập số CMNN/CCCD");
        this.add(cccd_number, "W 60%");
        
        phone_number = new MyTextField();
        phone_number.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Call.png")));
        phone_number.setHint("nhập số điện thoại");
        this.add(phone_number, "W 60%");
        
        birth = new MyTextField();
//        phone_number.setPrefixIcon(new ImageIcon(this.getClass()
//                .getClassLoader()
//                .getResource("icon/Call.png")));
        birth.setHint("nhập ngày sinh (thang-ngay-nam)");
        this.add(birth, "W 60%");
        
        password = new MyPasswordField();
        password.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Lock.png")));
        password.setHint("nhập mật khẩu");
        this.add(password, "W 60%");
        
        confirm_password = new MyPasswordField();
        confirm_password.setPrefixIcon(new ImageIcon(this.getClass()
                .getClassLoader()
                .getResource("icon/Lock.png")));
        confirm_password.setHint("nhập lại mật khẩu");
        
        this.add(confirm_password, "W 60%");
        register_button = new Button();
        register_button.setBackground(new Color(7, 164, 121));
        register_button.setForeground(new Color(250, 250, 250));
        register_button.setText("Sign Up");
        register_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanVien nv = new NhanVien();
                try {
                    nv.setMa( "nv" + (service.getMaxId() + 1) + "");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                nv.setTen(full_name.getText().trim());
                nv.setEmail(email.getText().trim());
                nv.setDiaChi(address.getText().trim());
                nv.setGioiTinh(male.isSelected() ? "Nam" : "Nu");
                nv.setSoDienThoai(phone_number.getText().trim());
                nv.setCccd(cccd_number.getText());
                
                Date date = new Date();
                try {
                    date = new SimpleDateFormat("MM-dd-yyyy").parse(birth.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "nhap sao ngay sinh");
                    return;
                }
                
                nv.setNgaySinh(date);
                if (new String(password.getPassword()).equals(new String(confirm_password.getPassword()))) {
                    nv.setPassword(new String(password.getPassword()));
                } else return;
                
                nv.setTrangThai("dang hoat dong");
                try {
                    if (service.insert(nv)) {
                        JOptionPane.showMessageDialog(null, "đăng kí thành công");
                    } else JOptionPane.showMessageDialog(null, "đăng kí thất bại");
                } catch (Exception ex) {
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
