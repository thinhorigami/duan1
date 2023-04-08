
package view;

import Domainmodel.KhachHang;
import viewmodel.KhuyenMaiViewmodel;
import Repositories.KhuyenMaiRepository;
import Service.KhachHangImpl;
import Service.QLKhuyenMai;
import ServiceImpl.KhachHangService;
import ServiceImpl.KhuyenMaiService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tuphph24187
 */
public class KhuyenMaiView extends javax.swing.JPanel {

    private KhachHangImpl khachHangService = new KhachHangService();
    private final QLKhuyenMai qLKhuyenMai;
    private DefaultTableModel model;
    public KhuyenMaiView() {
        initComponents();
               
        loadTableKhachHang();
        this.qLKhuyenMai = new KhuyenMaiService();
        this.model = new DefaultTableModel();
        loadTable();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    private void loadTableKhachHang() {
        model = new DefaultTableModel();
        ArrayList<KhachHang> list = khachHangService.getAll();
        model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);

        for (KhachHang khachHang : list) {
            model.addRow(new Object[]{
                khachHang.getEmail(),
                khachHang.getTen(),
                khachHang.getGioiTinh().equalsIgnoreCase("1") ? "Nam" : "Nữ",
                khachHang.getDiaChi(),
                khachHang.getNgaySinh(),
                khachHang.getDienThoai(),});

        }

    }

    private void loadTable() {
        ArrayList<KhuyenMaiViewmodel> list = qLKhuyenMai.getAll();
        model = (DefaultTableModel) tbKhuyenMai.getModel();
        model.setColumnCount(0);
        model.addColumn("Mã");
        model.addColumn("Tên");
        model.addColumn("Ngày bắt đầu");
        model.addColumn("Ngày kết thúc");
        model.addColumn("Giảm giá");
        model.addColumn("Đơn vị");
        model.addColumn("Mô tả");
        model.addColumn("Trạng thái");

        model.setRowCount(0);
        for (KhuyenMaiViewmodel k : list) {
            model.addRow(new Object[]{
                k.getMa(),
                k.getTenKM(),
                k.getNgayBatDau(),
                k.getNgayKetThuc(),
                k.getMuc_giam_gia(),
                k.getDonVi() == true ? "VND" : "%",
                k.getMoTa(),
                k.getTrangThai() == 1 ? "Hoạt động" : "Hết hạn"
            });

        }

    }

    private void sendEmail() {
        final String username = "concuakicuc2k";
        final String passs = "wwcsnhswydvmkgmb";

        Properties properties = new Properties(); //Cấu hình các cổng kết nối và quyền truy cập
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passs);
            }
        ;
        });

            try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("concuakicuc"));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(lbEmailChon.getText())
            );
            message.setSubject(txtName.getText());
            message.setText(txtMoTa.getText());
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Email sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void loadTableTimKiemTen(String ten) {
        ArrayList<KhuyenMaiViewmodel> list = qLKhuyenMai.timKiemTheoTen(ten);
        model = (DefaultTableModel) tbKhuyenMai.getModel();
        model.setColumnCount(0);
        model.addColumn("Id");
        model.addColumn("Mã");
        model.addColumn("Tên");
        model.addColumn("Giới tính");
        model.addColumn("Địa chỉ");
        model.addColumn("Ngày sinh");
        model.addColumn("Điện thoại");
        model.addColumn("Email");
        model.addColumn("Thành phố");
        model.setRowCount(0);
         for (KhuyenMaiViewmodel k : list) {
            model.addRow(new Object[]{
                k.getMa(),
                k.getTenKM(),
                k.getNgayBatDau(),
                k.getNgayKetThuc(),
                k.getMuc_giam_gia(),
                k.getDonVi() == true ? "VND" : "%",
                k.getMoTa(),
                k.getTrangThai() == 1 ? "Hoạt động" : "Hết hạn"
            });

        }
    }
    
    private void loadTableLocTrangThai(int trangThai){
        ArrayList<KhuyenMaiViewmodel> list = qLKhuyenMai.locTheoTrangThai(trangThai);
        model = (DefaultTableModel) tbKhuyenMai.getModel();
        model.setColumnCount(0);
        model.addColumn("Mã");
        model.addColumn("Tên");
        model.addColumn("Ngày bắt đầu");
        model.addColumn("Ngày kết thúc");
        model.addColumn("Giảm giá");
        model.addColumn("Đơn vị");
        model.addColumn("Mô tả");
        model.addColumn("Trạng thái");

        model.setRowCount(0);
        for (KhuyenMaiViewmodel k : list) {
            model.addRow(new Object[]{
                k.getMa(),
                k.getTenKM(),
                k.getNgayBatDau(),
                k.getNgayKetThuc(),
                k.getMuc_giam_gia(),
                k.getDonVi() == true ? "VND" : "%",
                k.getMoTa(),
                k.getTrangThai() == 1 ? "Hoạt động" : "Hết hạn"
            });

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdVND = new javax.swing.JRadioButton();
        rdPhanTram = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateBD = new com.github.lgooddatepicker.components.DatePicker();
        dateKT = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtTimTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel = new javax.swing.JPanel();
        cbkAll1 = new javax.swing.JCheckBox();
        btnEmailKH1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        lbEmailChon = new javax.swing.JLabel();

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel5.setPreferredSize(new java.awt.Dimension(888, 557));

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Ngày bắt đầu", "Ngày kết thúc", "Mức giảm", "Đơn vị", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbKhuyenMai);

        jLabel3.setText("Mã:");
        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        txtMa.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        jLabel2.setText("Tên:");
        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        jLabel5.setText("Mức giảm:");
        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        rdVND.setText("VND");
        rdVND.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        rdPhanTram.setText("%");

        jLabel6.setText("Ngày bắt đầu:");
        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        jLabel7.setText("Ngày kết thúc:");
        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        dateBD.setBackground(new java.awt.Color(255, 255, 255));

        dateKT.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Mô tả:");
        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        txtTimTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm kiếm:");

        btnThem.setText("Thêm");
        btnThem.setBackground(new java.awt.Color(0, 204, 204));
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setBackground(new java.awt.Color(0, 204, 204));
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Vô hiệu hóa");
        btnXoa.setBackground(new java.awt.Color(0, 204, 204));
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBackground(new java.awt.Color(0, 204, 204));
        btnLamMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnXoa))
                .addGap(56, 56, 56))
        );

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Hết hạn" }));
        cbbTrangThai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbbTrangThai.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtMucGiamGia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdVND, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdPhanTram))
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateBD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTimTen))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdVND)
                            .addComponent(rdPhanTram))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel5);

        cbkAll1.setText("Select All");

        btnEmailKH1.setText("Gửi Email thông báo khách hàng");
        btnEmailKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailKH1ActionPerformed(evt);
            }
        });

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Tên", "Giới tính", "Địa chỉ", "Ngày sinh", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.setGridColor(new java.awt.Color(255, 255, 255));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbKhachHang);

        lbEmailChon.setBackground(new java.awt.Color(255, 255, 255));
        lbEmailChon.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnEmailKH1))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(cbkAll1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEmailChon, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(cbkAll1)
                        .addGap(81, 81, 81)
                        .addComponent(btnEmailKH1))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(lbEmailChon, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Gửi Email Khách hàng", jPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
        btnThem.setEnabled(false);
        txtMa.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        try {
            int index = tbKhuyenMai.getSelectedRow();

            String ma = tbKhuyenMai.getValueAt(index, 0).toString();
            String Ten = tbKhuyenMai.getValueAt(index, 1).toString();
            String ngaybd = tbKhuyenMai.getValueAt(index, 2).toString();
            String ngaykt = tbKhuyenMai.getValueAt(index, 3).toString();
            String giamGia = tbKhuyenMai.getValueAt(index, 4).toString();
            String DonVi = tbKhuyenMai.getValueAt(index, 5).toString();
            String mota = tbKhuyenMai.getValueAt(index, 6).toString();
            txtMa.setText(ma);
            txtName.setText(Ten);
            dateBD.setText(ngaybd);
            dateKT.setText(ngaykt);
            txtMucGiamGia.setText(giamGia);
            txtMoTa.setText(mota);
            if (DonVi.equalsIgnoreCase("true")) {
                rdVND.setSelected(true);
                rdPhanTram.setSelected(false);
            } else {
                rdVND.setSelected(false);
                rdPhanTram.setSelected(true);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

    private void txtTimTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenKeyReleased
        loadTableTimKiemTen(txtTimTen.getText());
    }//GEN-LAST:event_txtTimTenKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhuyenMaiViewmodel kmv = new KhuyenMaiViewmodel();
        String start = dateBD.getDateStringOrEmptyString();
        String end = dateKT.getDateStringOrEmptyString();
        String maKM = txtMa.getText();
        String name = txtName.getText().replaceAll("\\s+", " ");
        String giamGia = txtMucGiamGia.getText();
        String moTa = txtMoTa.getText();

        for (KhuyenMaiViewmodel km : qLKhuyenMai.getAll()) {

            if (this.txtMa.getText().equals(km.getMa() + "")) {
                JOptionPane.showMessageDialog(this, "Không được để trùng mã");
                return;

            }
        }
        while (true) {
            if (maKM.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mã không được bỏ trống.");
                txtMa.grabFocus();
                return;
            } else if (maKM.length() > 50) {
                JOptionPane.showMessageDialog(null, "Độ dài tối đa của Mã là 50 ký tự.");
                txtMa.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (name.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Tên chương trình không được bỏ trống.");
                txtName.grabFocus();
                return;
            } else if (name.length() > 50) {
                JOptionPane.showMessageDialog(null, "Độ dài tối đa của tên chương trình là 50 ký tự.");
                txtName.grabFocus();
                return;
            } else {
                break;
            }
        }

        while (true) {
            if (txtMucGiamGia.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mức giảm giá không được bỏ trống.");
                txtMucGiamGia.grabFocus();
                return;
            } else if (!txtMucGiamGia.getText().trim().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Mức giảm giá phải là số nguyên dương");
                txtMucGiamGia.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (start.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu không được bỏ trống.");
                dateBD.grabFocus();
                return;
            } else if (end.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Ngày kết thúc không được bỏ trống.");
                dateKT.grabFocus();
                return;
            } else if (start.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (moTa.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mô tả chương trình không được bỏ trống.");
                txtMoTa.grabFocus();
                return;
            } else {
                break;
            }
        }

        kmv.setMa(maKM);
        kmv.setTenKM(name);
        kmv.setNgayBatDau(start);
        kmv.setNgayKetThuc(end);
        kmv.setMuc_giam_gia(Integer.valueOf(giamGia));
        kmv.setMoTa(moTa);
        kmv.setDonVi(rdVND.isSelected());
        kmv.setTrangThai(1);

        boolean kt = qLKhuyenMai.add(kmv);
        if (kt == true) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        KhuyenMaiViewmodel kmv = new KhuyenMaiViewmodel();
        String start = dateBD.getDateStringOrEmptyString();
        String end = dateKT.getDateStringOrEmptyString();
        String maKM = txtMa.getText();
        String name = txtName.getText().replaceAll("\\s+", " ");
        String giamGia = txtMucGiamGia.getText();
        String moTa = txtMoTa.getText();

        if (maKM.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã không được bỏ trống.");
            txtMa.grabFocus();
            return;

        }

        while (true) {
            if (name.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Tên chương trình không được bỏ trống.");
                txtName.grabFocus();
                return;
            } else if (name.length() > 50) {
                JOptionPane.showMessageDialog(null, "Độ dài tối đa của tên chương trình là 50 ký tự.");
                txtName.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (maKM.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mã không được bỏ trống.");
                txtMa.grabFocus();
                return;
            } else if (maKM.length() > 50) {
                JOptionPane.showMessageDialog(null, "Độ dài tối đa của Mã là 50 ký tự.");
                txtMa.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (txtMucGiamGia.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mức giảm giá không được bỏ trống.");
                txtMucGiamGia.grabFocus();
                return;
            } else if (!txtMucGiamGia.getText().trim().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Mức giảm giá phải là số nguyên dương");
                txtMucGiamGia.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (start.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (moTa.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mô tả chương trình không được bỏ trống.");
                txtMoTa.grabFocus();
                return;
            } else {
                break;
            }
        }

        kmv.setMa(maKM);
        kmv.setTenKM(name);
        kmv.setNgayBatDau(start);
        kmv.setNgayKetThuc(end);
        kmv.setMuc_giam_gia(Integer.valueOf(giamGia));
        kmv.setMoTa(moTa);
        kmv.setDonVi(rdVND.isSelected());
        kmv.setTrangThai(1);

        boolean kt = qLKhuyenMai.update(txtMa.getText(), kmv);
        if (kt == true) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //        boolean kt = qLKhuyenMai.delete(txtMa.getText());
        //        if (kt == true) {
            //            JOptionPane.showMessageDialog(this, "Xóa thành công");
            //            loadTable();
            //        } else {
            //            JOptionPane.showMessageDialog(this, "Xóa thất bại");
            //        }

        KhuyenMaiViewmodel kmv = new KhuyenMaiViewmodel();
        boolean kt = qLKhuyenMai.voHieuHoa(txtMa.getText(), kmv);
        if (kt == true) {
            JOptionPane.showMessageDialog(this, "Vô hiệu hóa thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Vô hiệu hóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        rdVND.setSelected(false);
        rdPhanTram.setSelected(false);
        btnThem.setEnabled(true);
        txtMa.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtName.setText("");
        txtMa.setText("");
        txtMucGiamGia.setText("");
        txtMoTa.setText("");
        dateBD.setText("");
        dateKT.setText("");
        txtTimTen.setText("");
        lbEmailChon.setText("");

        loadTable();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        if (cbbTrangThai.getSelectedItem().equals("Hoạt động")) {
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            loadTableLocTrangThai(1);
        } else if (cbbTrangThai.getSelectedItem().equals("Hết hạn")) {
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            loadTableLocTrangThai(0);

        }
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnEmailKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailKH1ActionPerformed
        sendEmail();
    }//GEN-LAST:event_btnEmailKH1ActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int index = tbKhachHang.getSelectedRow();
        String email = tbKhachHang.getValueAt(index, 0).toString();
        lbEmailChon.setText(email);
    }//GEN-LAST:event_tbKhachHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmailKH1;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JCheckBox cbkAll1;
    private com.github.lgooddatepicker.components.DatePicker dateBD;
    private com.github.lgooddatepicker.components.DatePicker dateKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbEmailChon;
    private javax.swing.JRadioButton rdPhanTram;
    private javax.swing.JRadioButton rdVND;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtMucGiamGia;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTimTen;
    // End of variables declaration//GEN-END:variables
}
