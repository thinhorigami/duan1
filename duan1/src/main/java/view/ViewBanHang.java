/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Domainmodel.HoaDon;
import Domainmodel.HoaDonChiTiet;
import Repositories.BanHangRepository;
import Repositories.ChiTietSanPhamRepository;
import Repositories.HoaDonRepository;
import Service.ChiTietSanPhamService;
import Service.HoaDonService;
import ServiceImpl.BanHangServiceImpl;
import ServiceImpl.ChiTietSanPhamServiceImpl;
import ServiceImpl.HoaDonServiceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCTViewModel;
import viewmodel.ViewModelHoaDonBanHang;
import viewmodel.ViewModelHoaDonChiTiet;

/**
 *
 * @author PC
 */
public class ViewBanHang extends javax.swing.JPanel {

    private DefaultComboBoxModel ccbKH = new DefaultComboBoxModel();
    private DefaultComboBoxModel ccbNV = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel ccbKM = new DefaultComboBoxModel();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dttm = new DefaultTableModel();
    List<HoaDon> hoaDons = new ArrayList<>();
    private List<ViewModelHoaDonBanHang> Bill = new ArrayList<>();

    private List<String> listKhachHang = new ArrayList<>();
    private List<String> listNhanVien = new ArrayList<>();
    private List<String> listKhuyenMai = new ArrayList<>();
    private List<String> listHoaDonCT = new ArrayList<>();
    List<SanPhamCTViewModel> listSearch = new ArrayList<>();
    private List<ViewModelHoaDonChiTiet> listHDCT = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();

    private DefaultTableModel tableHDCT = new DefaultTableModel();
    private DefaultTableModel tableHDT = new DefaultTableModel();
    DefaultTableModel model = new DefaultTableModel();
    private BanHangServiceImpl bh = new BanHangServiceImpl();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();
    private ArrayList<SanPhamCTViewModel> sp = chiTietSanPhamService.getAll();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();

    public void loadTable() {

        model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setColumnCount(0);

        model.addColumn("ID");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Nhà sản xuất");
        model.addColumn("Màu sắc");
        model.addColumn("Dòng sản phẩm");
        model.addColumn("Chất liệu");
        model.addColumn("Size");
        model.addColumn("Mô tả");
        model.addColumn("Số lượng tồn");
        model.addColumn("Giá nhập");
        model.addColumn("Giá bán");
        model.addColumn("Trạng thái");

        model.setRowCount(0);

        for (SanPhamCTViewModel sanPhamCTViewModel : sp) {
            model.addRow(new Object[]{
                sanPhamCTViewModel.getId(),
                sanPhamCTViewModel.getIdSP(),
                sanPhamCTViewModel.getIdNSX(),
                sanPhamCTViewModel.getIdMauSac(),
                sanPhamCTViewModel.getIdDongSanPham(),
                sanPhamCTViewModel.getIdChatLieu(),
                sanPhamCTViewModel.getIdSize(),
                sanPhamCTViewModel.getMoTa(),
                sanPhamCTViewModel.getSoLuongTon(),
                sanPhamCTViewModel.getGiaNhap(),
                sanPhamCTViewModel.getGiaBan(),
                sanPhamCTViewModel.getTrangThai() == 1 ? "Đang bán" : "Ngừng bán"
            });
        }
    }

    public void fillHoaDon(int row, List<ViewModelHoaDonBanHang> list) {

        ccbKhachHang.setSelectedItem(list.get(row).getTenkh());
        ccbNhanVien.setSelectedItem(list.get(row).getTennv());
        ccbKhuyenMai.setSelectedItem(list.get(row).getMaKm());

    }

    void showData(List<HoaDon> list) {
        dtm.setRowCount(0);
        for (HoaDon hoaDon : hoaDons) {
            dtm.addRow(hoaDon.toDataRow());
        }
    }

    void showDataHDCT(List<ViewModelHoaDonChiTiet> list) {
        dttm.setRowCount(0);
        for (ViewModelHoaDonChiTiet viewModelHoaDonChiTiet : list) {
            dttm.addRow(viewModelHoaDonChiTiet.dataRow());
        }
    }

    void showData3(List<ViewModelHoaDonBanHang> list) {
        dtm.setRowCount(0);
        for (ViewModelHoaDonBanHang hoaDon : Bill) {
            dtm.addRow(hoaDon.dataRow());
        }
    }

    public void thayDoiTien() {
        String maHD = lblHoaDonChon.getText();
        String maGG = String.valueOf(ccbKhuyenMai.getSelectedItem()).substring(0, 5);
        int tongTien = bh.layGiaTien(maHD);
        int giamGia = 0;

        if (bh.layDonViKM(maGG) == true) {
            giamGia = bh.layGiamGiaThuong(maGG);
        } else if (bh.layDonViKM(maGG) == false) {

        }

    }

    public ViewBanHang() throws SQLException {
        initComponents();

        loadTable();

        ccbKhachHang.setModel(ccbKH);
        ccbNhanVien.setModel(ccbNV);
        ccbKhuyenMai.setModel(ccbKM);
        bh.getAllTenNV(listNhanVien);
        bh.getAllTenKH(listKhachHang);
        bh.getAllKhuyenMai(listKhuyenMai);

        ccbKH.addAll(listKhachHang);
        ccbNV.addAll(listNhanVien);
        ccbKM.addAll(listKhuyenMai);

        ccbKhachHang.setSelectedIndex(0);
        ccbNhanVien.setSelectedIndex(0);
        ccbNhanVien.setSelectedIndex(0);
        ccbKhuyenMai.setSelectedIndex(0);

        tlbDanhSachHoaDonTrong.setModel(tableHDT);
        tblHoaDonChiTiet.setModel(tableHDCT);
        tblHoaDonChiTiet.setModel(dttm);
        tlbDanhSachHoaDonTrong.setModel(dtm);
//        hoaDons = hoaDonService.getAll();
        Bill = new BanHangRepository().getAllHoaDon();

//        String header[] = {"mã hóa đơn", "tên khách hàng", "tên nhân viên", "ngày tạo", "trạng thái", "ngày thanh toán", "khuyến mại"};
//        dtm.setColumnIdentifiers(header);
//        showData(hoaDons);
        String header[] = {"Mã hóa Đơn", "Tên Khách Hàng", "Tên Nhân Viên", "Ngày Tạo", "Trạng Thái", "Ngày Thanh Toán", "Thành Tiền"};
        dtm.setColumnIdentifiers(header);

        String[] headers = {"Tên sản phẩm", "Nhà sản xuất", "Màu sắc", "Dòng sản phẩm", "Chất liệu", "Size", "Mô tả", "Số lượng mua", "Giá bán", "Trạng Thái"};
        dttm.setColumnIdentifiers(headers);
        showData3(Bill);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ccbNhanVien = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ccbKhachHang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ccbKhuyenMai = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnHuyDon = new javax.swing.JButton();
        lblThanhTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbDanhSachHoaDonTrong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblHoaDonChon = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh Sách Sản Phẩm");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Dòng SP", "Hãng", "Size", "Màu", "Số Lượng", "Giá Bán", "Trạng Thái", "Chất Liệu"
            }
        ));
        jScrollPane2.setViewportView(tblDanhSachSanPham);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 500, 210));

        jLabel14.setText("Tìm Kiếm:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtTimKiemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSPKeyReleased(evt);
            }
        });
        jPanel4.add(txtTimKiemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 320, -1));

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Loại SP", "Hãng", "Size", "Đơn Giá", "Số Lượng", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane3.setViewportView(tblHoaDonChiTiet);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 500, 355));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Danh Sách Sản Phẩm Trong Hóa Đơn");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thông Tin Hóa Đơn");

        jLabel5.setText("Nhân Viên:");

        ccbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Khách Hàng:");

        ccbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Khuyến Mãi:");

        ccbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Tiền Khách Trả:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Tiền Thừa:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("Giảm giá:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Thành Tiền:");

        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyDon.setText("Hủy Đơn");

        lblThanhTien.setBackground(new java.awt.Color(255, 0, 51));
        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhTien.setText("0.0");

        lblGiamGia.setBackground(new java.awt.Color(255, 0, 51));
        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGiamGia.setText("0.0");

        lblTienThua.setBackground(new java.awt.Color(255, 0, 0));
        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienThua.setText("0.0");

        tlbDanhSachHoaDonTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Tên KH", "Tên NV", "Ngày Tạo", "Ngày Thanh Toán", "Thành Tiền"
            }
        ));
        tlbDanhSachHoaDonTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbDanhSachHoaDonTrongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlbDanhSachHoaDonTrong);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh Sách Hóa Đơn");

        lblHoaDonChon.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(lblGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(lblHoaDonChon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ccbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHoaDon))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ccbKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, 0, 162, Short.MAX_VALUE)
                                    .addComponent(ccbKhachHang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ccbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ccbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ccbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblThanhTien))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblGiamGia)
                    .addComponent(btnThanhToan)
                    .addComponent(btnHuyDon))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTienThua))
                .addGap(1, 1, 1)
                .addComponent(btnTaoHoaDon)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblHoaDonChon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void txtTimKiemSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSPKeyReleased
        // TODO add your handling code here:
        String name = txtTimKiemSP.getText();
        List<SanPhamCTViewModel> listSearch = bh.timTenSanPhamChiTiet(sp, name);
        model.setRowCount(0);
        for (SanPhamCTViewModel sanPhamCTViewModel : listSearch) {
            model.addRow(new Object[]{
                sanPhamCTViewModel.getId(),
                sanPhamCTViewModel.getIdSP(),
                sanPhamCTViewModel.getIdNSX(),
                sanPhamCTViewModel.getIdMauSac(),
                sanPhamCTViewModel.getIdDongSanPham(),
                sanPhamCTViewModel.getIdChatLieu(),
                sanPhamCTViewModel.getIdSize(),
                sanPhamCTViewModel.getMoTa(),
                sanPhamCTViewModel.getSoLuongTon(),
                sanPhamCTViewModel.getGiaNhap(),
                sanPhamCTViewModel.getGiaBan(),
                sanPhamCTViewModel.getTrangThai() == 1 ? "Đang bán" : "Ngừng bán"
            });
        }

    }//GEN-LAST:event_txtTimKiemSPKeyReleased

    private void tlbDanhSachHoaDonTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbDanhSachHoaDonTrongMouseClicked
        // TODO add your handling code here:
        int row = tlbDanhSachHoaDonTrong.getSelectedRow();
        String mahd = Bill.get(row).getMahd();
        try {
            listHDCT = new BanHangRepository().getAll(mahd);
            showDataHDCT(listHDCT);
            lblHoaDonChon.setText(mahd);
            lblGiamGia.setText(String.valueOf(Bill.get(row).getGiaGiam()));
            fillHoaDon(row, Bill);

            lblThanhTien.setText(String.valueOf(Bill.get(row).getThanhTien()));
        } catch (SQLException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tlbDanhSachHoaDonTrongMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
       int row = tlbDanhSachHoaDonTrong.getSelectedRow();
       String money = txtTienKhachTra.getText();
       Double price = Bill.get(row).getThanhTien();
       if(Double.valueOf(money) < price){
           JOptionPane.showMessageDialog(this, "Số tiền trả không đủ!!!");
       }else{
           System.out.println("Thanh toan Thanh cong");
       }
    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> ccbKhachHang;
    private javax.swing.JComboBox<String> ccbKhuyenMai;
    private javax.swing.JComboBox<String> ccbNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblHoaDonChon;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tlbDanhSachHoaDonTrong;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JTextField txtTimKiemSP;
    // End of variables declaration//GEN-END:variables
}
