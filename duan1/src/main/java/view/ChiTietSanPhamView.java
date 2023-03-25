/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import Service.ChatLieuService;
import Service.ChiTietSanPhamService;
import Service.DongSanPhamService;
import Service.MauSacService;
import Service.NhanViennService;
import Service.NsxService;
import Service.SanPhamService;
import Service.SizeService;
import ServiceImpl.ChatLieuServiceImpl;
import ServiceImpl.ChiTietSanPhamServiceImpl;
import ServiceImpl.DongSPServiceImpl;
import ServiceImpl.MauSacServiceImpl;
import ServiceImpl.NsxServiceImpl;
import ServiceImpl.SanPhamServiceImpl;
import ServiceImpl.SizeServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class ChiTietSanPhamView extends javax.swing.JPanel {

    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private NsxService nsxService = new NsxServiceImpl();

    private MauSacService mauSacService = new MauSacServiceImpl();

    private DongSanPhamService dongSanPhamService = new DongSPServiceImpl();

    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();

    private SizeService service = new SizeServiceImpl();

    DefaultTableModel model = new DefaultTableModel();

    public void loadTable() {
        ArrayList<SanPhamCTViewModel> sp = chiTietSanPhamService.getAll();
        model = (DefaultTableModel) tbbangChiTietSP.getModel();
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

    //load cbb sản phẩm
    //load cbb sản phẩm
    public void loadCBCSanPham() {
        cbbtenSanPham.removeAllItems();
        ArrayList<SanPhamDomain> list = (ArrayList<SanPhamDomain>) sanPhamService.getAll();
        for (SanPhamDomain i : list) {
            cbbtenSanPham.addItem(i.getTenSP());

        }
    }

    public String layIDSanPham(String tenCV) {
        String idCV = null;
        ArrayList<SanPhamDomain> list = (ArrayList<SanPhamDomain>) sanPhamService.getAll();
        for (SanPhamDomain chucVu : list) {
            if (chucVu.getTenSP().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    //load cbb nhà sản xuất
    public void loadCBCNSX() {
        cbbnhaSanXuat.removeAllItems();
        ArrayList<NSXdomain> list = (ArrayList<NSXdomain>) nsxService.getAll();
        for (NSXdomain i : list) {
            cbbnhaSanXuat.addItem(i.getTen());

        }
    }

    public String layIDNSX(String tenCV) {
        String idCV = null;
        ArrayList<NSXdomain> list = (ArrayList<NSXdomain>) nsxService.getAll();
        for (NSXdomain chucVu : list) {
            if (chucVu.getTen().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    //load cbb nhà màu sắc
    public void loadCBCMauSac() {
        cbbmauSac.removeAllItems();
        ArrayList<MauSacdomain> list = (ArrayList<MauSacdomain>) mauSacService.getAll();
        for (MauSacdomain i : list) {
            cbbmauSac.addItem(i.getTen());

        }
    }

    public String layIDMauSac(String tenCV) {
        String idCV = null;
        ArrayList<MauSacdomain> list = (ArrayList<MauSacdomain>) mauSacService.getAll();
        for (MauSacdomain chucVu : list) {
            if (chucVu.getTen().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    //load cbb dòng sản phẩm
    public void loadCBCDongSP() {
        cbbdongSanPham.removeAllItems();
        ArrayList<DongSPDomain> list = (ArrayList<DongSPDomain>) dongSanPhamService.getAll();
        for (DongSPDomain i : list) {
            cbbdongSanPham.addItem(i.getTen());

        }
    }

    public String layIDDongSP(String tenCV) {
        String idCV = null;
        ArrayList<DongSPDomain> list = (ArrayList<DongSPDomain>) dongSanPhamService.getAll();
        for (DongSPDomain chucVu : list) {
            if (chucVu.getTen().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    //load cbb chất liệu
    public void loadCBCChatLieu() {
        cbbchatLieu.removeAllItems();
        ArrayList<ChatLieuDomain> list = (ArrayList<ChatLieuDomain>) chatLieuService.getAll();
        for (ChatLieuDomain i : list) {
            cbbchatLieu.addItem(i.getTen());

        }
    }

    public String layIDChatLieu(String tenCV) {
        String idCV = null;
        ArrayList<ChatLieuDomain> list = (ArrayList<ChatLieuDomain>) chatLieuService.getAll();
        for (ChatLieuDomain chucVu : list) {
            if (chucVu.getTen().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    //load cbb size
    public void loadCBCSize() {
        cbbsize.removeAllItems();
        ArrayList<SizeDomain> list = (ArrayList<SizeDomain>) service.getAll();
        for (SizeDomain i : list) {
            cbbsize.addItem(i.getSoSize());

        }
    }

    public String layIDSize(String tenCV) {
        String idCV = null;
        ArrayList<SizeDomain> list = (ArrayList<SizeDomain>) service.getAll();
        for (SizeDomain chucVu : list) {
            if (chucVu.getSoSize().equals(tenCV) ) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    /**
     * Creates new form ChiTietSanPhamView
     */
    public ChiTietSanPhamView() {
        initComponents();
        loadTable();
        loadCBCNSX();
        loadCBCMauSac();
        loadCBCDongSP();
        loadCBCChatLieu();
        loadCBCSize();
        loadCBCSanPham();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbbtenSanPham = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbbnhaSanXuat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbmauSac = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbbdongSanPham = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbchatLieu = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbsize = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtmoTa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsoLuongTon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtgiaNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtgiaBan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdodangBan = new javax.swing.JRadioButton();
        rdonghiBan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbangChiTietSP = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setText("ID");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên sản phẩm");

        cbbtenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nhà sản xuất");

        cbbnhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Màu sắc");

        cbbmauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Dòng sản phẩm");

        cbbdongSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Chất liệu");

        cbbchatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Size");

        cbbsize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Mô tả");

        jLabel9.setText("Số lượng tồn");

        jLabel10.setText("Giá nhập");

        jLabel11.setText("Giá bán");

        jLabel12.setText("Trạng thái");

        buttonGroup1.add(rdodangBan);
        rdodangBan.setText("Đang bán");

        buttonGroup1.add(rdonghiBan);
        rdonghiBan.setText("Nghỉ bán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtsoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4))))
                            .addComponent(cbbnhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbdongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtgiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbtenSanPham, 0, 160, Short.MAX_VALUE)
                                    .addComponent(cbbmauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbchatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(txtgiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(rdodangBan)
                        .addGap(32, 32, 32)
                        .addComponent(rdonghiBan)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbmauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbnhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbtenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbdongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbbchatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtgiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtsoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtgiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(rdodangBan))
                    .addComponent(rdonghiBan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbbangChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbangChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbangChiTietSP);

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnthem)
                        .addGap(154, 154, 154)
                        .addComponent(btnsua)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        SanPhamCTViewModel ct = new SanPhamCTViewModel();
        String idSP = layIDSanPham((String) cbbtenSanPham.getSelectedItem());
        ct.setIdSP(idSP);

        String idNSX = layIDNSX((String) cbbnhaSanXuat.getSelectedItem());
        ct.setIdNSX(idNSX);

        String idMauSad = layIDMauSac((String) cbbmauSac.getSelectedItem());
        ct.setIdMauSac(idMauSad);

        String idDongSP = layIDDongSP((String) cbbdongSanPham.getSelectedItem());
        ct.setIdDongSanPham(idDongSP);

        String idChatLieu = layIDChatLieu((String) cbbchatLieu.getSelectedItem());
        ct.setIdChatLieu(idChatLieu);

        String idSize =  layIDSize((String) cbbsize.getSelectedItem());
        ct.setIdSize(idSize);
        
//        Integer size = new Integer((int) cbbsize.getSelectedItem());
//        String layIString = layIDSize(size);
//        ct.setIdSize(layIString);

        ct.setMoTa(txtmoTa.getText());

        Integer soLuong = new Integer(txtsoLuongTon.getText());
        ct.setSoLuongTon(soLuong);
        System.out.println(soLuong);

        BigDecimal giaNhap = new BigDecimal(txtgiaNhap.getText());
        ct.setGiaNhap(giaNhap);

        BigDecimal giaBan = new BigDecimal(txtgiaBan.getText());
        ct.setGiaBan(giaBan);
        ct.setTrangThai(1);
  
        boolean kt = chiTietSanPhamService.add(ct);
        if(kt == true){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }

    }//GEN-LAST:event_btnthemActionPerformed

    private void tbbangChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangChiTietSPMouseClicked
        // TODO add your handling code here:
           int index = tbbangChiTietSP.getSelectedRow();
        txtid.setText(tbbangChiTietSP.getValueAt(index, 0).toString());
        
        String trangThai = tbbangChiTietSP.getValueAt(index, 11).toString();
        cbbtenSanPham.setSelectedItem(tbbangChiTietSP.getValueAt(index, 1).toString());
        cbbnhaSanXuat.setSelectedItem(tbbangChiTietSP.getValueAt(index, 2).toString());
        cbbmauSac.setSelectedItem(tbbangChiTietSP.getValueAt(index, 3).toString());
        cbbdongSanPham.setSelectedItem(tbbangChiTietSP.getValueAt(index, 4).toString());
        cbbchatLieu.setSelectedItem(tbbangChiTietSP.getValueAt(index, 5).toString());
//        cbbsize.setSelectedItem(tbbangChiTietSP.getValueAt(index, 6).toString());
        txtmoTa.setText(tbbangChiTietSP.getValueAt(index, 7).toString());
        txtsoLuongTon.setText(tbbangChiTietSP.getValueAt(index, 8).toString());
        txtgiaNhap.setText(tbbangChiTietSP.getValueAt(index, 9).toString());
        txtgiaBan.setText(tbbangChiTietSP.getValueAt(index, 10).toString());
        
        if (trangThai.equals("Đang bán")) {
            rdodangBan.setSelected(true);
        } else {
            rdonghiBan.setSelected(true);
        }

    }//GEN-LAST:event_tbbangChiTietSPMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
         SanPhamCTViewModel ct = new SanPhamCTViewModel();
        String idSP = layIDSanPham((String) cbbtenSanPham.getSelectedItem());
        ct.setIdSP(idSP);

        String idNSX = layIDNSX((String) cbbnhaSanXuat.getSelectedItem());
        ct.setIdNSX(idNSX);

        String idMauSad = layIDMauSac((String) cbbmauSac.getSelectedItem());
        ct.setIdMauSac(idMauSad);

        String idDongSP = layIDDongSP((String) cbbdongSanPham.getSelectedItem());
        ct.setIdDongSanPham(idDongSP);

        String idChatLieu = layIDChatLieu((String) cbbchatLieu.getSelectedItem());
        ct.setIdChatLieu(idChatLieu);

        String idSize = layIDSize((String) cbbsize.getSelectedItem());
        ct.setIdSize(idSize);

        ct.setMoTa(txtmoTa.getText());

        Integer soLuong = new Integer(txtsoLuongTon.getText());
        ct.setSoLuongTon(soLuong);

        BigDecimal giaNhap = new BigDecimal(txtgiaNhap.getText());
        ct.setGiaNhap(giaNhap);

        BigDecimal giaBan = new BigDecimal(txtgiaBan.getText());
        ct.setGiaBan(giaBan);
        
         if (rdodangBan.isSelected()) {
            ct.setTrangThai(1);
        } else {
            ct.setTrangThai(0);
        }
  
        boolean kt = chiTietSanPhamService.update(txtid.getText(), ct);
        if(kt == true){
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }

    }//GEN-LAST:event_btnsuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbchatLieu;
    private javax.swing.JComboBox<String> cbbdongSanPham;
    private javax.swing.JComboBox<String> cbbmauSac;
    private javax.swing.JComboBox<String> cbbnhaSanXuat;
    private javax.swing.JComboBox<String> cbbsize;
    private javax.swing.JComboBox<String> cbbtenSanPham;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdodangBan;
    private javax.swing.JRadioButton rdonghiBan;
    private javax.swing.JTable tbbangChiTietSP;
    private javax.swing.JTextField txtgiaBan;
    private javax.swing.JTextField txtgiaNhap;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmoTa;
    private javax.swing.JTextField txtsoLuongTon;
    // End of variables declaration//GEN-END:variables
}
