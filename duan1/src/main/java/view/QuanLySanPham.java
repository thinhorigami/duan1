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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCTViewModel;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Phuong Bi
 */
public class QuanLySanPham extends javax.swing.JPanel {
    
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private NsxService nsxService = new NsxServiceImpl();

    private MauSacService mauSacService = new MauSacServiceImpl();

    private DongSanPhamService dongSanPhamService = new DongSPServiceImpl();

    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();

    private SizeService service = new SizeServiceImpl();

    DefaultTableModel model = new DefaultTableModel();
    
     private DefaultTableModel dtmMS = new DefaultTableModel();
     
    
    private List<MauSacdomain> listMauSac = new ArrayList<>();
    
    private DefaultTableModel dtmDSP = new DefaultTableModel();
    private DongSanPhamService dsp = new DongSPServiceImpl();
    private List<DongSPDomain> listDSP = new ArrayList<>();
    
    private DefaultTableModel dtmCL = new DefaultTableModel();
    private List<ChatLieuDomain> listCL = new ArrayList<>();
    private ChatLieuService clService = new ChatLieuServiceImpl();
    
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private List<SanPhamDomain> listSP = new ArrayList<>();
    private SanPhamService spService = new SanPhamServiceImpl();
    
    private DefaultTableModel dtmNsx = new DefaultTableModel();
    private List<NSXdomain> listNsx = new ArrayList<>();
    
    
    private DefaultTableModel dtmSize = new DefaultTableModel();
    private List<SizeDomain> listSize = new ArrayList<>();
    private SizeService sizeService = new SizeServiceImpl();
    
    public void loadTableSize() {
        ArrayList<SizeDomain> s = (ArrayList<SizeDomain>) sizeService.getAll();
        dtmSize = (DefaultTableModel) tbSize.getModel();
        dtmSize.setColumnCount(0);
        dtmSize.addColumn("Id");
        dtmSize.addColumn("Mã size");
        dtmSize.addColumn("Số size");
        dtmSize.addColumn("Trạng thái");
        
        dtmSize.setRowCount(0);
        
        for (SizeDomain sizeDomain : s) {
            dtmSize.addRow(new Object[]{
                sizeDomain.getId(),
                sizeDomain.getMa(),
                sizeDomain.getSoSize(),
                sizeDomain.getTrangThai()
            });
            
        }
        
    }
    
   
    
    public void showDataMauSac(List<MauSacdomain> lists) {
        dtmMS.setRowCount(0);
        for (MauSacdomain ms : lists) {
            dtmMS.addRow(ms.toDataRow());
        }
    }
    
    private void fillDataMS(int i) {
        MauSacdomain ms = listMauSac.get(i);
        txtMaMS.setText(ms.getMa());
        txtTenMS.setText(ms.getTen());
    }
    
    public void showDataDongSP(List<DongSPDomain> lists) {
        dtmDSP.setRowCount(0);
        for (DongSPDomain ms : lists) {
            dtmDSP.addRow(ms.toDataRow());
        }
    }
    
    private void fillDataDongSP(int i) {
        DongSPDomain ms = listDSP.get(i);
        txtMaDSP.setText(ms.getMa());
        txtTenDSP.setText(ms.getTen());
    }
    
    public void showDataChatLieu(List<ChatLieuDomain> lists) {
        dtmCL.setRowCount(0);
        for (ChatLieuDomain ms : lists) {
            dtmCL.addRow(ms.toDataRow());
        }
    }
    
    private void fillDataChatLieu(int i) {
        ChatLieuDomain ms = listCL.get(i);
        txtMaCL.setText(ms.getMa());
        txtTenCL.setText(ms.getTen());
    }
    
    public void showDataSanPham(List<SanPhamDomain> lists) {
        dtmSP.setRowCount(0);
        for (SanPhamDomain sp : lists) {
            dtmSP.addRow(sp.toDataRow());
        }
    }
    
    private void fillDataSanPham(int i) {
        SanPhamDomain sp = listSP.get(i);
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
    }
    
    public void showDataNsx(List<NSXdomain> lists) {
        dtmNsx.setRowCount(0);
        for (NSXdomain nsx : lists) {
            dtmNsx.addRow(nsx.toDataRow());
        }
    }
    
    private void fillDataNsx(int i) {
        NSXdomain ms = listNsx.get(i);
        txtMaNsx.setText(ms.getMa());
        txtTenNsx.setText(ms.getTen());
    }
    
    public void showDataSize(List<SizeDomain> lists) {
        dtmSize.setRowCount(0);
        for (SizeDomain ms : lists) {
            dtmSize.addRow(ms.toDataRow());
        }
    }
    
    private void fillDataSize(int i) {
        SizeDomain ms = listSize.get(i);
        txtMaSize.setText(ms.getMa());
        txtSoSize.setText(String.valueOf(ms.getSoSize()));
    }
    
    public static String gen(String ma) {
        int last = (int) Math.floor((Math.random()) * 9);
        if (last < 1000 && last >= 100) {
            return ma + "0" + last;
        }
        if (last < 100 && last >= 10) {
            return ma + "00" + last;
        }
        if (last < 10) {
            return ma + "000" + last;
        }
        
        return ma + last;
        
    }
    
 

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
     * Creates new form QuanLySanPham
     */
    public QuanLySanPham() {
        initComponents();
         loadTable();
        loadCBCNSX();
        loadCBCMauSac();
        loadCBCDongSP();
        loadCBCChatLieu();
        loadCBCSize();
        loadCBCSanPham();
        
          tbMS.setModel(dtmMS);
        String[] headers1 = {"Mã Màu Sắc", "Tên Màu Sắc"};
        dtmMS.setColumnIdentifiers(headers1);
        listMauSac = mauSacService.getAll();
        showDataMauSac(listMauSac);
        
        tbDongSP.setModel(dtmDSP);
        String[] headers2 = {"Mã Dòng SP", "Tên Dòng SP"};
        dtmDSP.setColumnIdentifiers(headers2);
        listDSP = dsp.getAll();
        showDataDongSP(listDSP);
        txtMaDSP.setEditable(false);
        
        tbCL.setModel(dtmCL);
        String[] headers3 = {"Mã", "Tên"};
        dtmCL.setColumnIdentifiers(headers3);
        listCL = clService.getAll();
        showDataChatLieu(listCL);
        
        tbSP.setModel(dtmSP);
        String[] headers4 = {"Mã", "Tên"};
        dtmSP.setColumnIdentifiers(headers4);
        listSP = spService.getAll();
        showDataSanPham(listSP);
        
        tbNhaSanXuat.setModel(dtmNsx);
        String[] headers5 = {"Mã", "Tên"};
        dtmNsx.setColumnIdentifiers(headers5);
        listNsx = nsxService.getAll();
        showDataNsx(listNsx);

//        tbSize.setModel(dtmSize);
//        String[] headers6 = {"Mã", "So Size"};
//        dtmSize.setColumnIdentifiers(headers6);
//        listSize = sizeService.getAll();
//        showDataSize(listSize);
        loadTableSize();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
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
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbangChiTietSP = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTenDSP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaDSP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDongSP = new javax.swing.JTable();
        btnAddDSP = new javax.swing.JButton();
        btnUpdateDSP = new javax.swing.JButton();
        btnDeleteDSP = new javax.swing.JButton();
        btnCLearDSP = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        btnAddSP = new javax.swing.JButton();
        btnUpdateSP = new javax.swing.JButton();
        btnDeleteSP = new javax.swing.JButton();
        btnCLearSP = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtTenCL = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMaCL = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCL = new javax.swing.JTable();
        btnAddCL = new javax.swing.JButton();
        btnUpdateCL = new javax.swing.JButton();
        btnDeleteCL = new javax.swing.JButton();
        btnCLearCL = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTenMS = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtMaMS = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMS = new javax.swing.JTable();
        btnAddMS = new javax.swing.JButton();
        btnUpdateMS = new javax.swing.JButton();
        btnDeleteMS = new javax.swing.JButton();
        btnCLearMS = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtSoSize = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSize = new javax.swing.JTable();
        btnAddMS1 = new javax.swing.JButton();
        btnUpdateMS1 = new javax.swing.JButton();
        btnDeleteMS1 = new javax.swing.JButton();
        btnCLearMS1 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtTenNsx = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtMaNsx = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbNhaSanXuat = new javax.swing.JTable();
        btnAddDSP1 = new javax.swing.JButton();
        btnUpdateDSP1 = new javax.swing.JButton();
        btnDeleteDSP1 = new javax.swing.JButton();
        btnCLearDSP1 = new javax.swing.JButton();

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

        rdodangBan.setText("Đang bán");

        rdonghiBan.setText("Nghỉ bán");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)
                        .addGap(288, 288, 288)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(102, 102, 102))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbbdongSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(110, 110, 110)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtsoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4))))
                            .addComponent(cbbnhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtgiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbtenSanPham, 0, 160, Short.MAX_VALUE)
                                    .addComponent(cbbmauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbchatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel11))
                            .addGroup(jPanel5Layout.createSequentialGroup()
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
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbmauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbnhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbtenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbdongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbbchatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtgiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtsoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtgiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(rdodangBan))
                    .addComponent(rdonghiBan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnthem)
                        .addGap(154, 154, 154)
                        .addComponent(btnsua)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel2);

        jPanel12.setBackground(new java.awt.Color(51, 153, 0));

        jLabel13.setText("Tên");

        jLabel14.setText("Mã");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Dòng Sản Phẩm");

        tbDongSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDongSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDongSP);

        btnAddDSP.setText("Add");
        btnAddDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDSPActionPerformed(evt);
            }
        });

        btnUpdateDSP.setText("Update");
        btnUpdateDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDSPActionPerformed(evt);
            }
        });

        btnDeleteDSP.setText("Remove");
        btnDeleteDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDSPActionPerformed(evt);
            }
        });

        btnCLearDSP.setText("Clear");
        btnCLearDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearDSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenDSP, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaDSP))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel15))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnAddDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(btnUpdateDSP)
                        .addGap(85, 85, 85)
                        .addComponent(btnDeleteDSP)
                        .addGap(85, 85, 85)
                        .addComponent(btnCLearDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDSP)
                    .addComponent(btnUpdateDSP)
                    .addComponent(btnDeleteDSP)
                    .addComponent(btnCLearDSP))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Dòng sản phẩm", jPanel8);

        jPanel13.setBackground(new java.awt.Color(51, 153, 0));

        jLabel16.setText("Tên");

        jLabel17.setText("Mã");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Sản Phẩm");

        tbSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSP);

        btnAddSP.setText("Add");
        btnAddSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSPActionPerformed(evt);
            }
        });

        btnUpdateSP.setText("Update");
        btnUpdateSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSPActionPerformed(evt);
            }
        });

        btnDeleteSP.setText("Remove");
        btnDeleteSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSPActionPerformed(evt);
            }
        });

        btnCLearSP.setText("Clear");
        btnCLearSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSP)))
                        .addGap(241, 241, 241)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteSP)
                            .addComponent(btnCLearSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateSP))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearSP))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Sản phẩm", jPanel9);

        jPanel14.setBackground(new java.awt.Color(51, 153, 0));

        jLabel19.setText("Tên");

        jLabel20.setText("Mã");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Chất Liệu");

        tbCL.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCLMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbCL);

        btnAddCL.setText("Add");
        btnAddCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCLActionPerformed(evt);
            }
        });

        btnUpdateCL.setText("Update");
        btnUpdateCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCLActionPerformed(evt);
            }
        });

        btnDeleteCL.setText("Remove");
        btnDeleteCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCLActionPerformed(evt);
            }
        });

        btnCLearCL.setText("Clear");
        btnCLearCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearCLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenCL, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaCL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateCL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddCL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteCL)
                            .addComponent(btnCLearCL, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtMaCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCL))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateCL, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtTenCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnDeleteCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCLearCL))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Chất liệu", jPanel10);

        jPanel15.setBackground(new java.awt.Color(0, 153, 0));

        jLabel22.setText("Tên");

        jLabel23.setText("Mã");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("Màu Sắc");

        tbMS.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMSMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbMS);

        btnAddMS.setText("Add");
        btnAddMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMSActionPerformed(evt);
            }
        });

        btnUpdateMS.setText("Update");
        btnUpdateMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMSActionPerformed(evt);
            }
        });

        btnDeleteMS.setText("Remove");
        btnDeleteMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMSActionPerformed(evt);
            }
        });

        btnCLearMS.setText("Clear");
        btnCLearMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearMSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenMS, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaMS)))
                        .addGap(241, 241, 241)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddMS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteMS)
                            .addComponent(btnCLearMS, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMS))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateMS, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtTenMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteMS)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearMS))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Màu sắc", jPanel11);

        jPanel16.setBackground(new java.awt.Color(0, 153, 0));

        jLabel25.setText("Tên");

        jLabel26.setText("Mã");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("Màu Sắc");

        tbSize.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSizeMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbSize);

        btnAddMS1.setText("Add");
        btnAddMS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMS1ActionPerformed(evt);
            }
        });

        btnUpdateMS1.setText("Update");
        btnUpdateMS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMS1ActionPerformed(evt);
            }
        });

        btnDeleteMS1.setText("Remove");
        btnDeleteMS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMS1ActionPerformed(evt);
            }
        });

        btnCLearMS1.setText("Clear");
        btnCLearMS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearMS1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoSize, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSize))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnAddMS1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnUpdateMS1)
                        .addGap(84, 84, 84)
                        .addComponent(btnDeleteMS1)
                        .addGap(53, 53, 53)
                        .addComponent(btnCLearMS1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtSoSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMS1)
                    .addComponent(btnUpdateMS1)
                    .addComponent(btnDeleteMS1)
                    .addComponent(btnCLearMS1))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab1", jPanel16);

        jTabbedPane2.addTab("Size", jTabbedPane3);

        jPanel17.setBackground(new java.awt.Color(51, 153, 0));

        jLabel28.setText("Tên");

        jLabel29.setText("Mã");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setText("Nha San Xuat");

        tbNhaSanXuat.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhaSanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhaSanXuatMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbNhaSanXuat);

        btnAddDSP1.setText("Add");
        btnAddDSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDSP1ActionPerformed(evt);
            }
        });

        btnUpdateDSP1.setText("Update");
        btnUpdateDSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDSP1ActionPerformed(evt);
            }
        });

        btnDeleteDSP1.setText("Remove");
        btnDeleteDSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDSP1ActionPerformed(evt);
            }
        });

        btnCLearDSP1.setText("Clear");
        btnCLearDSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearDSP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenNsx, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaNsx))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnAddDSP1)
                .addGap(135, 135, 135)
                .addComponent(btnUpdateDSP1)
                .addGap(94, 94, 94)
                .addComponent(btnDeleteDSP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(btnCLearDSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtMaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtTenNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDSP1)
                    .addComponent(btnUpdateDSP1)
                    .addComponent(btnDeleteDSP1)
                    .addComponent(btnCLearDSP1))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("NhaSX", jPanel17);

        jTabbedPane2.addTab("Nhà sản xuất", jTabbedPane4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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

    private void tbDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDongSPMouseClicked
        // TODO add your handling code here:
        int row = tbDongSP.getSelectedRow();
        fillDataDongSP(row);
    }//GEN-LAST:event_tbDongSPMouseClicked

    private void btnAddDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDSPActionPerformed
        // TODO add your handling code here:
        String ma = gen("DSP");
        String ten = txtTenDSP.getText();

        DongSPDomain dongSanPham = new DongSPDomain(ma, ten);
        String add = dsp.add(dongSanPham);
        JOptionPane.showMessageDialog(this, add);
        listDSP = dsp.getAll();
        showDataDongSP(listDSP);
    }//GEN-LAST:event_btnAddDSPActionPerformed

    private void btnUpdateDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDSPActionPerformed
        // TODO add your handling code here:
        int row = tbDongSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listDSP.get(row).getId();
            String ma = txtMaDSP.getText();
            String ten = txtTenDSP.getText();
            DongSPDomain dongSanPham = new DongSPDomain(ma, ten);
            String update = dsp.update(dongSanPham, id);
            JOptionPane.showMessageDialog(this, update);
            listDSP = dsp.getAll();
            showDataDongSP(listDSP);
        }
    }//GEN-LAST:event_btnUpdateDSPActionPerformed

    private void btnDeleteDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDSPActionPerformed
        // TODO add your handling code here:
        int row = tbDongSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listDSP.get(row).getId();
            String delete = dsp.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listDSP = dsp.getAll();
            showDataDongSP(listDSP);
            txtMaDSP.setText("");
            txtTenDSP.setText("");
        }
    }//GEN-LAST:event_btnDeleteDSPActionPerformed

    private void btnCLearDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearDSPActionPerformed
        // TODO add your handling code here:
        txtMaDSP.setText("");
        txtTenDSP.setText("");
    }//GEN-LAST:event_btnCLearDSPActionPerformed

    private void tbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPMouseClicked
        // TODO add your handling code here:
        int row = tbSP.getSelectedRow();
        fillDataSanPham(row);
    }//GEN-LAST:event_tbSPMouseClicked

    private void btnAddSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSPActionPerformed
        // TODO add your handling code here:
        String ma = gen("SP");
        String ten = txtTenSP.getText();

        SanPhamDomain sp = new SanPhamDomain(ma, ten);
        String add = spService.add(sp);
        JOptionPane.showMessageDialog(this, add);
        listSP = spService.getAll();
        showDataSanPham(listSP);
    }//GEN-LAST:event_btnAddSPActionPerformed

    private void btnUpdateSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSPActionPerformed
        // TODO add your handling code here:
        int row = tbSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listSP.get(row).getId();
            String ma = txtMaSP.getText();
            String ten = txtTenSP.getText();
            SanPhamDomain sp = new SanPhamDomain(ma, ten);
            String update = spService.update(sp, id);
            JOptionPane.showMessageDialog(this, update);
            listSP = spService.getAll();
            showDataSanPham(listSP);
        }
    }//GEN-LAST:event_btnUpdateSPActionPerformed

    private void btnDeleteSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSPActionPerformed
        // TODO add your handling code here:
        int row = tbSP.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listSP.get(row).getId();
            String delete = spService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listSP = spService.getAll();
            showDataSanPham(listSP);
            txtMaDSP.setText("");
            txtTenDSP.setText("");
        }
    }//GEN-LAST:event_btnDeleteSPActionPerformed

    private void btnCLearSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearSPActionPerformed

    private void tbCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCLMouseClicked
        // TODO add your handling code here:
        int row = tbCL.getSelectedRow();
        fillDataChatLieu(row);
    }//GEN-LAST:event_tbCLMouseClicked

    private void btnAddCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCLActionPerformed
        // TODO add your handling code here:
        String ma = gen("CL");
        String ten = txtTenCL.getText();

        ChatLieuDomain cl = new ChatLieuDomain(ma, ten);
        String add = clService.add(cl);
        JOptionPane.showMessageDialog(this, add);
        listCL = clService.getAll();
        showDataChatLieu(listCL);
    }//GEN-LAST:event_btnAddCLActionPerformed

    private void btnUpdateCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCLActionPerformed
        // TODO add your handling code here:
        int row = tbCL.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listCL.get(row).getId();
            String ma = txtMaCL.getText();
            String ten = txtTenCL.getText();
            ChatLieuDomain cl = new ChatLieuDomain(ma, ten);
            String update = clService.update(cl, id);
            JOptionPane.showMessageDialog(this, update);
            listCL = clService.getAll();
            showDataChatLieu(listCL);
        }
    }//GEN-LAST:event_btnUpdateCLActionPerformed

    private void btnDeleteCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCLActionPerformed
        // TODO add your handling code here:
        int row = tbCL.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listCL.get(row).getId();
            String delete = clService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listCL = clService.getAll();
            showDataChatLieu(listCL);
            txtMaCL.setText("");
            txtTenCL.setText("");
        }
    }//GEN-LAST:event_btnDeleteCLActionPerformed

    private void btnCLearCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearCLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearCLActionPerformed

    private void tbMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMSMouseClicked
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        fillDataMS(row);
    }//GEN-LAST:event_tbMSMouseClicked

    private void btnAddMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMSActionPerformed
        // TODO add your handling code here:
        String ma = gen("MS");
        String ten = txtTenMS.getText();

        MauSacdomain cl = new MauSacdomain(ma, ten);
        String add = mauSacService.add(cl);
        JOptionPane.showMessageDialog(this, add);
        listMauSac = mauSacService.getAll();
        showDataMauSac(listMauSac);
    }//GEN-LAST:event_btnAddMSActionPerformed

    private void btnUpdateMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMSActionPerformed
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listMauSac.get(row).getId();
            String ma = txtMaMS.getText();
            String ten = txtTenMS.getText();
            MauSacdomain cl = new MauSacdomain(ma, ten);
            String update = mauSacService.update(cl, id);
            JOptionPane.showMessageDialog(this, update);
            listMauSac = mauSacService.getAll();
            showDataMauSac(listMauSac);
        }
    }//GEN-LAST:event_btnUpdateMSActionPerformed

    private void btnDeleteMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMSActionPerformed
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listMauSac.get(row).getId();
            String delete = mauSacService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listMauSac = mauSacService.getAll();
            showDataMauSac(listMauSac);
            txtMaMS.setText("");
            txtTenMS.setText("");
        }
    }//GEN-LAST:event_btnDeleteMSActionPerformed

    private void btnCLearMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearMSActionPerformed

    private void tbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSizeMouseClicked
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        fillDataMS(row);
    }//GEN-LAST:event_tbSizeMouseClicked

    private void btnAddMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMS1ActionPerformed
        // TODO add your handling code here:
        String ma = gen("MS");
        String ten = txtTenMS.getText();

        MauSacdomain cl = new MauSacdomain(ma, ten);
        String add = mauSacService.add(cl);
        JOptionPane.showMessageDialog(this, add);
        listMauSac = mauSacService.getAll();
        showDataMauSac(listMauSac);
    }//GEN-LAST:event_btnAddMS1ActionPerformed

    private void btnUpdateMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMS1ActionPerformed
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listMauSac.get(row).getId();
            String ma = txtMaMS.getText();
            String ten = txtTenMS.getText();
            MauSacdomain cl = new MauSacdomain(ma, ten);
            String update = mauSacService.update(cl, id);
            JOptionPane.showMessageDialog(this, update);
            listMauSac = mauSacService.getAll();
            showDataMauSac(listMauSac);
        }
    }//GEN-LAST:event_btnUpdateMS1ActionPerformed

    private void btnDeleteMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMS1ActionPerformed
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listMauSac.get(row).getId();
            String delete = mauSacService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listMauSac = mauSacService.getAll();
            showDataMauSac(listMauSac);
            txtMaMS.setText("");
            txtTenMS.setText("");
        }
    }//GEN-LAST:event_btnDeleteMS1ActionPerformed

    private void btnCLearMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearMS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearMS1ActionPerformed

    private void tbNhaSanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhaSanXuatMouseClicked
        // TODO add your handling code here:
        int row = tbNhaSanXuat.getSelectedRow();
        fillDataNsx(row);
    }//GEN-LAST:event_tbNhaSanXuatMouseClicked

    private void btnAddDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDSP1ActionPerformed
        // TODO add your handling code here:
        String ma = gen("NSX");
        String ten = txtTenNsx.getText();

        NSXdomain cl = new NSXdomain(ma, ten);
        String add = nsxService.add(cl);
        JOptionPane.showMessageDialog(this, add);
        listNsx = nsxService.getAll();
        showDataNsx(listNsx);
    }//GEN-LAST:event_btnAddDSP1ActionPerformed

    private void btnUpdateDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDSP1ActionPerformed
        // TODO add your handling code here:
        int row = tbNhaSanXuat.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listNsx.get(row).getId();
            String ma = txtMaNsx.getText();
            String ten = txtTenNsx.getText();
            NSXdomain cl = new NSXdomain(ma, ten);
            String update = nsxService.update(cl, id);
            JOptionPane.showMessageDialog(this, update);
            listNsx = nsxService.getAll();
            showDataNsx(listNsx);
        }
    }//GEN-LAST:event_btnUpdateDSP1ActionPerformed

    private void btnDeleteDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDSP1ActionPerformed
        // TODO add your handling code here:
        int row = tbNhaSanXuat.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listNsx.get(row).getId();
            String delete = nsxService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
            listNsx = nsxService.getAll();
            showDataNsx(listNsx);
            txtMaNsx.setText("");
            txtTenNsx.setText("");
        }
    }//GEN-LAST:event_btnDeleteDSP1ActionPerformed

    private void btnCLearDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearDSP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearDSP1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCL;
    private javax.swing.JButton btnAddDSP;
    private javax.swing.JButton btnAddDSP1;
    private javax.swing.JButton btnAddMS;
    private javax.swing.JButton btnAddMS1;
    private javax.swing.JButton btnAddSP;
    private javax.swing.JButton btnCLearCL;
    private javax.swing.JButton btnCLearDSP;
    private javax.swing.JButton btnCLearDSP1;
    private javax.swing.JButton btnCLearMS;
    private javax.swing.JButton btnCLearMS1;
    private javax.swing.JButton btnCLearSP;
    private javax.swing.JButton btnDeleteCL;
    private javax.swing.JButton btnDeleteDSP;
    private javax.swing.JButton btnDeleteDSP1;
    private javax.swing.JButton btnDeleteMS;
    private javax.swing.JButton btnDeleteMS1;
    private javax.swing.JButton btnDeleteSP;
    private javax.swing.JButton btnUpdateCL;
    private javax.swing.JButton btnUpdateDSP;
    private javax.swing.JButton btnUpdateDSP1;
    private javax.swing.JButton btnUpdateMS;
    private javax.swing.JButton btnUpdateMS1;
    private javax.swing.JButton btnUpdateSP;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JRadioButton rdodangBan;
    private javax.swing.JRadioButton rdonghiBan;
    private javax.swing.JTable tbCL;
    private javax.swing.JTable tbDongSP;
    private javax.swing.JTable tbMS;
    private javax.swing.JTable tbNhaSanXuat;
    private javax.swing.JTable tbSP;
    private javax.swing.JTable tbSize;
    private javax.swing.JTable tbbangChiTietSP;
    private javax.swing.JTextField txtMaCL;
    private javax.swing.JTextField txtMaDSP;
    private javax.swing.JTextField txtMaMS;
    private javax.swing.JTextField txtMaNsx;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtSoSize;
    private javax.swing.JTextField txtTenCL;
    private javax.swing.JTextField txtTenDSP;
    private javax.swing.JTextField txtTenMS;
    private javax.swing.JTextField txtTenNsx;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtgiaBan;
    private javax.swing.JTextField txtgiaNhap;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmoTa;
    private javax.swing.JTextField txtsoLuongTon;
    // End of variables declaration//GEN-END:variables
}
