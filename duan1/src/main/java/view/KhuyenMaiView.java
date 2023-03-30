/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Domainmodel.KhachHang;
import Domainmodel.KhuyenMai;

import Repositories.KhuyenMaiRepository;
import Service.KhachHangImpl;
import Service.QLKhuyenMai;
import ServiceImpl.KhachHangService;
import ServiceImpl.KhuyenMaiService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author concu
 */
public class KhuyenMaiView extends javax.swing.JFrame {

    private final KhachHangImpl khachHangService = new KhachHangService();
    private final QLKhuyenMai qLKhuyenMai;
    private DefaultTableModel model;
    public KhuyenMaiView() {
        initComponents();
        setLocationRelativeTo(null);
        loadTableKhachHang();
        this.qLKhuyenMai = new KhuyenMaiService();
        this.model = new DefaultTableModel();
        loadTable();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        PanelTimKiem.setVisible(false);
        btnTimKiem.setVisible(false);
    }

    private void loadTable() {
        ArrayList<KhuyenMai> list = qLKhuyenMai.getAll();
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
        for (KhuyenMai k : list) {
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

    private void loadTableKhachHang() {
        model = new DefaultTableModel();
        ArrayList<KhachHang> list = khachHangService.getAll();
        model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);

        for (KhachHang khachHang : list) {
            model.addRow(new Object[]{
                false,
                khachHang.getEmail(),
                khachHang.getTen(),
                //                khachHang.getGioiTinh().equalsIgnoreCase("1")?"Nam" :"Nữ",
                //                khachHang.getDiaChi(),
                //                khachHang.getNgaySinh(),
                khachHang.getDienThoai(),});

        }

    }

    private void timKiem(ArrayList<KhuyenMai> list) {
        KhuyenMaiRepository kmr = new KhuyenMaiRepository();
        model = (DefaultTableModel) tbKhuyenMai.getModel();
        model.setRowCount(0);
        for (KhuyenMai km : list) {
            if (km.getTenKM().equals(txtTimTen.getText())) {
                model.addRow(new Object[]{
                    km.getMa(),
                    km.getTenKM(),
                    km.getNgayBatDau(),
                    km.getNgayKetThuc(),
                    km.getMuc_giam_gia(),
                    km.getDonVi() == true ? "VND" : "%",
                    km.getMoTa(),
                    km.getTrangThai() == 1 ? "Hoạt động" : "Hết hạn"
                });
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        PanelTimKiem = new javax.swing.JPanel();
        txtTimTen = new javax.swing.JTextField();
        dateBD1 = new com.github.lgooddatepicker.components.DatePicker();
        dateKT1 = new com.github.lgooddatepicker.components.DatePicker();
        cbChonTimKiem = new javax.swing.JComboBox();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdVND = new javax.swing.JRadioButton();
        rdPhanTram = new javax.swing.JRadioButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnLamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateBD = new com.github.lgooddatepicker.components.DatePicker();
        dateKT = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        cbkAll1 = new javax.swing.JCheckBox();
        btnEmailKH1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(888, 557));

        PanelTimKiem.setBackground(new java.awt.Color(255, 255, 255));

        txtTimTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenKeyReleased(evt);
            }
        });

        dateBD1.setBackground(new java.awt.Color(255, 255, 255));

        dateKT1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateBD1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateKT1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateBD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateKT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        cbChonTimKiem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Tìm kiếm theo---", "Tên", "Ngày", " " }));
        cbChonTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbChonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChonTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

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
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtMa.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        jLabel2.setText("Tên:");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setText("Mức giảm:");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setText("Đơn vị:");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        rdVND.setText("VND");

        rdPhanTram.setText("%");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Hết hạn" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBackground(new java.awt.Color(255, 183, 239));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày bắt đầu:");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setText("Ngày kết thúc:");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        dateBD.setBackground(new java.awt.Color(255, 255, 255));

        dateKT.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Mô tả:");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnThem.setText("Thêm");
        btnThem.setBackground(new java.awt.Color(255, 183, 239));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setBackground(new java.awt.Color(255, 183, 239));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setBackground(new java.awt.Color(255, 183, 239));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(rdVND, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(rdPhanTram))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cbChonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTimKiem))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbChonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(rdVND))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(rdPhanTram)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6))
                            .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7))
                            .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLamMoi)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel5);

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

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
                "", "Email", "Tên", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jLabel1.setText("Tìm khách hàng(theo Email):");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmailKH1)
                            .addComponent(cbkAll1)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbkAll1)
                .addGap(18, 18, 18)
                .addComponent(btnEmailKH1)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Gửi Email khách hàng", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenKeyReleased

    }//GEN-LAST:event_txtTimTenKeyReleased

    private void cbChonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChonTimKiemActionPerformed
        PanelTimKiem.setVisible(true);
        if (cbChonTimKiem.getSelectedIndex() == 0) {

            btnTimKiem.setVisible(false);

            dateBD1.setVisible(false);
            dateKT1.setVisible(false);

            txtTimTen.setVisible(false);

        } else if (cbChonTimKiem.getSelectedItem().equals("Tên")) {
            btnTimKiem.setVisible(true);

            dateBD1.setVisible(false);
            dateKT1.setVisible(false);

            txtTimTen.setVisible(true);

        } else if (cbChonTimKiem.getSelectedItem().equals("Ngày")) {
            btnTimKiem.setVisible(true);

            dateBD1.setVisible(true);
            dateKT1.setVisible(true);

            txtTimTen.setVisible(false);

        }
    }//GEN-LAST:event_cbChonTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (cbChonTimKiem.getSelectedItem().equals("Tên")) {
            if (txtTimTen.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khuyến mãi");
                return;
            } else {
                String timkm = txtTimTen.getText();
                try {
                    timKiem((ArrayList<KhuyenMai>) qLKhuyenMai.timKiem(txtTimTen.getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Hiển thị thất bại");
                }
            }
        } else if (cbChonTimKiem.getSelectedItem().equals("Ngày")) {

        } else if (cbChonTimKiem.getSelectedItem().equals("Mức giảm giá")) {

        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
        btnThem.setEnabled(false);
        txtMa.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
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
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed

        if (cbbTrangThai.getSelectedItem().equals("Hoạt động")) {

        } else if (cbbTrangThai.getSelectedItem().equals("Hết hạn")) {

        }
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

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
        cbChonTimKiem.setSelectedIndex(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhuyenMai kmv = new KhuyenMai();
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
        for (KhuyenMai km : qLKhuyenMai.getAll()) {

            if (this.txtMa.getText().equals(km.getMa() + "")) {
                JOptionPane.showMessageDialog(this, "Không được để trùng mã");
                return;

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

        boolean kt = qLKhuyenMai.add(kmv);
        if (kt == true) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        KhuyenMai kmv = new KhuyenMai();
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
        boolean kt = qLKhuyenMai.delete(txtMa.getText());
        if (kt == true) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnEmailKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailKH1ActionPerformed

    }//GEN-LAST:event_btnEmailKH1ActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked

    }//GEN-LAST:event_tbKhachHangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JButton btnEmailKH1;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cbChonTimKiem;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JCheckBox cbkAll1;
    private com.github.lgooddatepicker.components.DatePicker dateBD;
    private com.github.lgooddatepicker.components.DatePicker dateBD1;
    private com.github.lgooddatepicker.components.DatePicker dateKT;
    private com.github.lgooddatepicker.components.DatePicker dateKT1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
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
