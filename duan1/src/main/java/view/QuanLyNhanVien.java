/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Domainmodel.NhanVien;
import Service.ChucVuService;
import Service.NhanVienService;
import ServiceImpl.ChucVuServiceImpl;
import ServiceImpl.NhanVienServiceImpl;
import Utilities.MailVerificate;
import Utilities.SendMail;
import Utilities.VietNamPattern;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import viewmodel.ChucVuviewModel;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author nguye
 */
public class QuanLyNhanVien extends javax.swing.JLayeredPane {

  private NhanVienService nhan_vien_service;
  private ChucVuService chuc_vu_service;
  private NhanVien nhan_vien; // nhân viên đang được thao tác (CRUD) 
  private RegisterDialog reg_dlg;
  private Loading loading;
  private MailVerificate mv;
  private long code;

  /**
   * Creates new form QuanLyNhanVien
   */
  public QuanLyNhanVien(Frame _parent) throws Exception {
    initComponents();
    this.mv = new MailVerificate();
    loading = new Loading() {
      @Override
      public boolean onLoading() {
        code = new Random()
                .ints(100000, 999999)
                .findFirst()
                .getAsInt();
        var sm = new SendMail();
        sm.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
        sm.send(nhan_vien.getEmail(), "Thông báo cập nhật không tin","\n Mã xác nhận: " + code);
        return sm.isResult();
      }

      @Override
      public void onSuccess() {
        try {
          if (!mv.Verficate(code)) {
            JOptionPane.showMessageDialog(null, "xác thực email " + nhan_vien.getEmail() + " thất bại");
          }
        } catch (InterruptedException ex) {
          Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mv.isResult()) {
          nhan_vien_service.update(nhan_vien).ifPresentOrElse((o) -> {
            JOptionPane.showMessageDialog(null, "cập nhật thông tin thành công");
            try {
              initData(nhan_vien_service.getByTrangThai(2 - view_option.getSelectedIndex()));
            } catch (Exception ex) {
              Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
          }, () -> {
            JOptionPane.showMessageDialog(null, "cập nhật thông tin thất bại");
          });
        }
      }

      @Override
      public void onFailed() {
        JOptionPane.showMessageDialog(null, "không thể gửi mã xác thực đến email " + nhan_vien.getEmail());
      }
    };
    
    loading.setSize(this.getSize());
    loading.setBounds(this.getBounds());
    this.setLayer(loading, POPUP_LAYER);
    this.add(loading);
    this.reg_dlg = new RegisterDialog(_parent, true);
    this.nhan_vien = new NhanVien();
    this.nhan_vien_service = new NhanVienServiceImpl();
    this.chuc_vu_service = new ChucVuServiceImpl();
    emptyText();

    ten.setPattern(VietNamPattern.TEN);
    ten.setErrorMsg("tên không hợp lệ");

    email.setPattern("^[0-9a-zA-Z.]+@[0-9a-zA-Z.]+$");
    email.setErrorMsg("email không hợp lệ");

    dia_chi.setPattern(VietNamPattern.DIA_CHI);
    dia_chi.setErrorMsg("địa chỉ không hợp lệ");

    so_dien_thoai.setPattern("^[0-9]{10}$");
    so_dien_thoai.setErrorMsg("số điện thoại không hợp lệ");
    this.initData(this.nhan_vien_service.getAll());
    this.table_data.setAutoCreateRowSorter(true);
  }

  public void initData(List<NhanVien> _data) throws Exception {
    emptyText();
    this.nghi_viec.setEnabled(false);
    this.update.setEnabled(false);
    NhanVienViewModel table = new NhanVienViewModel();
    table.fillData(_data);
    table_data.setModel(table.getModel());
    ChucVuviewModel cvvm = new ChucVuviewModel();
    fillLabel();
  }

  public void fillLabel() {
    ten_er.setText(ten.getLabel().getText());
    email_err.setText(email.getLabel().getText());
    phone_number_err.setText(so_dien_thoai.getLabel().getText());
    address_er.setText(dia_chi.getLabel().getText());
  }

  public void emptyText() {
    this.ten.setText("");
    this.ma.setText("");
    this.dia_chi.setText("");
    this.email.setText("");
    this.ngay_sinh.setText("");
    this.dia_chi.setText("");
    this.so_dien_thoai.setText("");
    this.trang_thai.setText("");
  }

  public void fillText(NhanVien _nv) {
    this.ma.setText(_nv.getMa());
    this.ten.setText(_nv.getTen());
    this.email.setText(_nv.getEmail());
    this.dia_chi.setText(_nv.getDiaChi());
    this.so_dien_thoai.setText(this.nhan_vien.getDienThoai());
    if (_nv.getGioiTinh().compareTo("Nam") == 0) {
      this.nam.setSelected(true);
    } else {
      this.nu.setSelected(true);
    }
    this.ngay_sinh.setDate(Instant.ofEpochMilli(_nv.getNgaySinh().getTime())
            .atZone(ZoneId.systemDefault())
            .toLocalDate());
    this.trang_thai.setText(_nv.getTrangThai() == 1 ? "đang hoạt động" : "không còn hoạt động");
  }

  public void mappText() throws ParseException {
    this.nhan_vien.setTen(this.ten.getText());
    this.nhan_vien.setMa(this.ma.getText());
    this.nhan_vien.setEmail(this.email.getText());
    this.nhan_vien.setDiaChi(this.dia_chi.getText());
    this.nhan_vien.setDienThoai(this.so_dien_thoai.getText());
    this.nhan_vien.setGioiTinh(this.nam.isSelected() ? "Nam" : "Nữ");
    this.nhan_vien.setNgaySinh(Date.from(this.ngay_sinh.getDate()
            .atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant()));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jScrollPane1 = new javax.swing.JScrollPane();
    table_data = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    nam = new javax.swing.JRadioButton();
    nu = new javax.swing.JRadioButton();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    update = new javax.swing.JButton();
    ngay_sinh = new com.github.lgooddatepicker.components.DatePicker();
    jButton2 = new javax.swing.JButton();
    ma = new javax.swing.JLabel();
    ten_er = new javax.swing.JLabel();
    email_err = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    phone_number_err = new javax.swing.JLabel();
    ten = new view.login.swing.ValidateTextField();
    email = new view.login.swing.ValidateTextField();
    label1 = new java.awt.Label();
    address_er = new javax.swing.JLabel();
    dia_chi = new view.login.swing.ValidateTextField();
    so_dien_thoai = new view.login.swing.ValidateTextField();
    jLabel10 = new javax.swing.JLabel();
    search = new javax.swing.JTextField();
    jLabel11 = new javax.swing.JLabel();
    view_option = new javax.swing.JComboBox<>();
    jLabel12 = new javax.swing.JLabel();
    trang_thai = new javax.swing.JLabel();
    nghi_viec = new javax.swing.JButton();

    table_data.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    table_data.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        table_dataMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(table_data);

    jLabel1.setText("mã nhân viên");

    jLabel2.setText("tên nhân viên");

    buttonGroup1.add(nam);
    nam.setSelected(true);
    nam.setText("Nam");

    buttonGroup1.add(nu);
    nu.setText("Nữ");

    jLabel3.setText("giới tính");

    jLabel4.setText("email");

    jLabel5.setText("số điện thoại");

    jLabel6.setText("trạng thái");

    jLabel7.setText("địa chỉ");

    jLabel8.setText("ngay_sinh");

    update.setText("cập nhật thông tin");
    update.setBackground(new java.awt.Color(0, 102, 51));
    update.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    update.setForeground(new java.awt.Color(255, 255, 255));
    update.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateActionPerformed(evt);
      }
    });

    jButton2.setText("đăng ký");
    jButton2.setBackground(new java.awt.Color(0, 102, 51));
    jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    ma.setText("jLabel9");

    ten_er.setText("ten");
    ten_er.setForeground(new java.awt.Color(255, 0, 0));

    email_err.setText("email");
    email_err.setForeground(new java.awt.Color(255, 0, 0));

    jLabel9.setForeground(new java.awt.Color(255, 0, 0));

    phone_number_err.setText("phone number");
    phone_number_err.setForeground(new java.awt.Color(255, 0, 0));

    ten.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tenActionPerformed(evt);
      }
    });

    email.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        emailActionPerformed(evt);
      }
    });

    label1.setAlignment(java.awt.Label.CENTER);
    label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    label1.setForeground(new java.awt.Color(0, 153, 102));
    label1.setText("Quản lý nhân viên");

    address_er.setText("dia chi");
    address_er.setForeground(new java.awt.Color(255, 0, 0));

    dia_chi.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        dia_chiActionPerformed(evt);
      }
    });

    so_dien_thoai.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        so_dien_thoaiActionPerformed(evt);
      }
    });

    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
    jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel10MouseClicked(evt);
      }
    });

    search.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchActionPerformed(evt);
      }
    });

    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
    jLabel11.setToolTipText("làm mới");
    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel11MouseClicked(evt);
      }
    });

    view_option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tất cả nhân viên", "đang hoạt động", "không còn hoạt động" }));
    view_option.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        view_optionActionPerformed(evt);
      }
    });

    jLabel12.setText("hiện");
    jLabel12.setForeground(new java.awt.Color(0, 102, 51));

    trang_thai.setText("jLabel13");

    nghi_viec.setBackground(new java.awt.Color(0, 102, 51));
    nghi_viec.setForeground(new java.awt.Color(255, 255, 255));
    nghi_viec.setText("nghỉ việc");
    nghi_viec.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    nghi_viec.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nghi_viecActionPerformed(evt);
      }
    });

    setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(nam, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(nu, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(update, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(ngay_sinh, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(ma, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(ten_er, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(email_err, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(phone_number_err, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(ten, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(email, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(label1, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(address_er, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(dia_chi, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(so_dien_thoai, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(search, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(view_option, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(trang_thai, javax.swing.JLayeredPane.DEFAULT_LAYER);
    setLayer(nghi_viec, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel6)
              .addComponent(ten, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
              .addComponent(ten_er)
              .addComponent(trang_thai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(email_err)
              .addComponent(jLabel4)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel8)
                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ngay_sinh, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
            .addGap(23, 23, 23)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel5)
                  .addComponent(phone_number_err)
                  .addComponent(address_er)
                  .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(nghi_viec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addComponent(so_dien_thoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(dia_chi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_option, 0, 1, Short.MAX_VALUE))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(ma, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(nam)
                    .addGap(18, 18, 18)
                    .addComponent(nu))
                  .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE)))))
        .addContainerGap())
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel12)
            .addComponent(view_option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(jLabel3)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ma)
          .addComponent(nam)
          .addComponent(nu)
          .addComponent(dia_chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(address_er)
        .addGap(19, 19, 19)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(jLabel4)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(so_dien_thoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(email_err)
              .addComponent(ten_er)
              .addComponent(phone_number_err))
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(jLabel8))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ngay_sinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(trang_thai))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nghi_viec, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addGap(99, 99, 99)
            .addComponent(jLabel9)))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(10, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
      if (this.table_data.getSelectedRowCount() != 1) {
        return;
      }

      this.nghi_viec.setEnabled(true);
      this.update.setEnabled(true);

      this.nhan_vien_service
              .getByMa(this.table_data
                      .getValueAt(this.table_data.getSelectedRow(), 0)
                      .toString())
              .ifPresent((o) -> {
                this.nhan_vien = o;
                this.fillText(this.nhan_vien);
              });

    }//GEN-LAST:event_table_dataMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

      if (this.table_data.getSelectedRowCount() != 1) {
        JOptionPane.showMessageDialog(this, "hãy chọn một nhân viên trong bảng dưới trước khi update");
        return;
      }
      
      if (nhan_vien.getTrangThai() == 0) {
        JOptionPane.showMessageDialog(null, "không thể cập nhật thông tin vì nhân viên " +nhan_vien.getMa() + " không còn hoạt động");
        return;
      }
      
      int t = LocalDate.now().getYear() - this.ngay_sinh.getDate().getYear();
      if (t < 18 || t > 30) {
        JOptionPane.showMessageDialog(null, "tuổi phải lớn hơn 18 và nhỏ hơn 30");
        return;
      }
      
      fillLabel();
      if (!ten.isResult()
              || !dia_chi.isResult()
              || !email.isResult()
              || !so_dien_thoai.isResult()) {
        JOptionPane.showMessageDialog(null, "thông tin không hợp lệ, vui lòng kiểm tra lại");
        return;
      }
      
      if (!nhan_vien_service.updateable(this.nhan_vien.getMa(), this.email.getText(), this.so_dien_thoai.getText())) {
        JOptionPane.showMessageDialog(null, "email hoặc số điện thoại đã tồn tại");
        return;
      }

      try {
        this.mappText();
      } catch (ParseException ex) {
        Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
        Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      try {
        loading.Start();
        this.loading.setVisible(true);
      } catch (InterruptedException ex) {
        Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
      }
      emptyText();
    }//GEN-LAST:event_updateActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.reg_dlg.setVisible(true);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_tenActionPerformed

  private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_emailActionPerformed

  private void dia_chiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dia_chiActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_dia_chiActionPerformed

  private void so_dien_thoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_so_dien_thoaiActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_so_dien_thoaiActionPerformed

  private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    table_data.clearSelection();
    this.nhan_vien_service.getByMa(search.getText().trim(), 2 - view_option.getSelectedIndex()).ifPresentOrElse((o) -> {
      for (var i = 0; i < this.table_data.getRowCount(); ++i) {
        
        if (this.table_data.getValueAt(i, 0).equals(o.getMa())) {
          table_data.setRowSelectionInterval(i, i);
        }
      }
      this.nhan_vien = o;
      this.nghi_viec.setEnabled(true);
      this.update.setEnabled(true);
      fillText(o);
    }, () -> {
      emptyText();
      JOptionPane.showMessageDialog(null, "không tìm thấy nhân viên có mã " + search.getText().trim());
      search.setText("");
    });
  }//GEN-LAST:event_jLabel10MouseClicked

  private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_searchActionPerformed

  private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    try {
      initData(this.nhan_vien_service
              .getByTrangThai(2 - view_option.getSelectedIndex()));
    } catch (Exception ex) {
      Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_jLabel11MouseClicked

  private void view_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_optionActionPerformed
    try {
      initData(nhan_vien_service.getByTrangThai(2 - view_option.getSelectedIndex()));
    } catch (Exception ex) {
      Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_view_optionActionPerformed

  private void nghi_viecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nghi_viecActionPerformed
    int result = JOptionPane.showConfirmDialog(this, "xác nhận cho nhân viên " + this.nhan_vien.getMa() + " nghỉ việc", "thông báo", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      if (nhan_vien_service.getChucVu(nhan_vien).get().getTen().equals("quản lý")) {
        JOptionPane.showMessageDialog(null, "không thể cho nhân viên " + nhan_vien.getMa() + " nghỉ việc");
        return;
      }
      nhan_vien.setTrangThai(0);
      nhan_vien_service.update(nhan_vien).ifPresentOrElse((o) -> {
        JOptionPane.showMessageDialog(null, "nhân viên " + nhan_vien.getMa() + " đã nghỉ việc");
      }, () -> {
        JOptionPane.showMessageDialog(null, "lỗi: không thể cho nhân viên " + nhan_vien.getMa() + " nghỉ việc");
      });
      try {
        initData(nhan_vien_service.getByTrangThai(2 - view_option.getSelectedIndex()));
      } catch (Exception ex) {
        return;
      }
    }
  }//GEN-LAST:event_nghi_viecActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel address_er;
  private javax.swing.ButtonGroup buttonGroup1;
  private view.login.swing.ValidateTextField dia_chi;
  private view.login.swing.ValidateTextField email;
  private javax.swing.JLabel email_err;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private java.awt.Label label1;
  private javax.swing.JLabel ma;
  private javax.swing.JRadioButton nam;
  private com.github.lgooddatepicker.components.DatePicker ngay_sinh;
  private javax.swing.JButton nghi_viec;
  private javax.swing.JRadioButton nu;
  private javax.swing.JLabel phone_number_err;
  private javax.swing.JTextField search;
  private view.login.swing.ValidateTextField so_dien_thoai;
  private javax.swing.JTable table_data;
  private view.login.swing.ValidateTextField ten;
  private javax.swing.JLabel ten_er;
  private javax.swing.JLabel trang_thai;
  private javax.swing.JButton update;
  private javax.swing.JComboBox<String> view_option;
  // End of variables declaration//GEN-END:variables
}
