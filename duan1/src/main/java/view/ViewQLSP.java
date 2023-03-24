/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import Service.ChatLieuService;
import Service.DongSanPhamService;
import Service.MauSacService;
import Service.NsxService;
import Service.SanPhamService;
import Service.SizeService;
import ServiceImpl.ChatLieuServiceImpl;
import ServiceImpl.DongSPServiceImpl;
import ServiceImpl.MauSacServiceImpl;
import ServiceImpl.NsxServiceImpl;
import ServiceImpl.SanPhamServiceImpl;
import ServiceImpl.SizeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84982
 */
public class ViewQLSP extends javax.swing.JFrame {

    /**
     * Creates new form ViewQLSP
     */
    private DefaultTableModel dtmMS = new DefaultTableModel();
    private MauSacService mauSacService = new MauSacServiceImpl();
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
    private NsxService nsxService = new NsxServiceImpl();
    
    private DefaultTableModel dtmSize = new DefaultTableModel();
    private List<SizeDomain> listSize = new ArrayList<>();
    private SizeService sizeService = new SizeServiceImpl();
    
    public ViewQLSP() {
        initComponents();
        
        
        tbMS.setModel(dtmMS);
        String[] headers1 = { "Mã Màu Sắc", "Tên Màu Sắc"};
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
        
        tbSize.setModel(dtmSize);
        String[] headers6 = {"Mã", "So Size"};
        dtmSize.setColumnIdentifiers(headers6);
        listSize = sizeService.getAll();
        showDataSize(listSize);
        
    }
    public void showDataMauSac(List<MauSacdomain> lists){
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
    
    public void showDataDongSP(List<DongSPDomain> lists){
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
    public void showDataChatLieu(List<ChatLieuDomain> lists){
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
    
    public void showDataSanPham(List<SanPhamDomain> lists){
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
    
    public void showDataNsx(List<NSXdomain> lists){
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
    
    public void showDataSize(List<SizeDomain> lists){
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTenDSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaDSP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDongSP = new javax.swing.JTable();
        btnAddDSP = new javax.swing.JButton();
        btnUpdateDSP = new javax.swing.JButton();
        btnDeleteDSP = new javax.swing.JButton();
        btnCLearDSP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        btnAddSP = new javax.swing.JButton();
        btnUpdateSP = new javax.swing.JButton();
        btnDeleteSP = new javax.swing.JButton();
        btnCLearSP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTenCL = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaCL = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCL = new javax.swing.JTable();
        btnAddCL = new javax.swing.JButton();
        btnUpdateCL = new javax.swing.JButton();
        btnDeleteCL = new javax.swing.JButton();
        btnCLearCL = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTenMS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMaMS = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMS = new javax.swing.JTable();
        btnAddMS = new javax.swing.JButton();
        btnUpdateMS = new javax.swing.JButton();
        btnDeleteMS = new javax.swing.JButton();
        btnCLearMS = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtSoSize = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSize = new javax.swing.JTable();
        btnAddMS1 = new javax.swing.JButton();
        btnUpdateMS1 = new javax.swing.JButton();
        btnDeleteMS1 = new javax.swing.JButton();
        btnCLearMS1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNsx = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaNsx = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhaSanXuat = new javax.swing.JTable();
        btnAddDSP1 = new javax.swing.JButton();
        btnUpdateDSP1 = new javax.swing.JButton();
        btnDeleteDSP1 = new javax.swing.JButton();
        btnCLearDSP1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(51, 153, 0));

        jLabel3.setText("Tên");

        jLabel2.setText("Mã");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Dòng Sản Phẩm");

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
        jScrollPane1.setViewportView(tbDongSP);

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenDSP, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaDSP)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDSP)
                    .addComponent(btnUpdateDSP))
                .addGap(180, 180, 180))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteDSP)
                            .addComponent(btnCLearDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDSP))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteDSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearDSP))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("DongSP", jPanel2);

        jPanel10.setBackground(new java.awt.Color(51, 153, 0));

        jLabel7.setText("Tên");

        jLabel8.setText("Mã");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Sản Phẩm");

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSP)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddSP)
                    .addComponent(btnUpdateSP))
                .addGap(180, 180, 180))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteSP)
                            .addComponent(btnCLearSP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateSP))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteSP)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearSP))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel3);

        jPanel11.setBackground(new java.awt.Color(51, 153, 0));

        jLabel10.setText("Tên");

        jLabel11.setText("Mã");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Chất Liệu");

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenCL, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaCL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCL)
                    .addComponent(btnUpdateCL))
                .addGap(180, 180, 180))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteCL)
                            .addComponent(btnCLearCL, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCL))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateCL))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteCL)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearCL))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chất Liệu", jPanel4);

        jPanel12.setBackground(new java.awt.Color(0, 153, 0));

        jLabel13.setText("Tên");

        jLabel14.setText("Mã");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Màu Sắc");

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenMS, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaMS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddMS)
                    .addComponent(btnUpdateMS))
                .addGap(180, 180, 180))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteMS)
                            .addComponent(btnCLearMS, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMS))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateMS))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteMS)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearMS))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Màu Sắc", jPanel5);

        jPanel13.setBackground(new java.awt.Color(51, 153, 0));

        jLabel16.setText("Tên");

        jLabel17.setText("Mã");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Size");

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

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(btnAddMS1))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(btnUpdateMS1))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteMS1)
                    .addComponent(btnCLearMS1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMS1))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(txtSoSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateMS1))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnDeleteMS1)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearMS1))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Size", jPanel6);

        jPanel9.setBackground(new java.awt.Color(51, 153, 0));

        jLabel4.setText("Tên");

        jLabel5.setText("Mã");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Nha San Xuat");

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
        jScrollPane2.setViewportView(tbNhaSanXuat);

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenNsx, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaNsx)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDSP1)
                    .addComponent(btnUpdateDSP1))
                .addGap(180, 180, 180))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteDSP1)
                            .addComponent(btnCLearDSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel6)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDSP1))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateDSP1))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteDSP1)
                        .addGap(18, 18, 18)
                        .addComponent(btnCLearDSP1))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NhaSX", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCLearDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearDSP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearDSP1ActionPerformed

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

    private void tbNhaSanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhaSanXuatMouseClicked
        // TODO add your handling code here:
        int row = tbNhaSanXuat.getSelectedRow();
        fillDataNsx(row);
    }//GEN-LAST:event_tbNhaSanXuatMouseClicked

    private void btnCLearMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearMS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearMS1ActionPerformed

    private void btnDeleteMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMS1ActionPerformed
        // TODO add your handling code here:
        int row = tbSize.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listSize.get(row).getId();
            String delete = sizeService.delete(id);
            JOptionPane.showMessageDialog(this, delete);
             listSize = sizeService.getAll();
            showDataSize(listSize);
            txtMaSize.setText("");
            txtSoSize.setText("");
        }
        
    }//GEN-LAST:event_btnDeleteMS1ActionPerformed

    private void btnUpdateMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMS1ActionPerformed
        // TODO add your handling code here:
        int row = tbSize.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Data");
        } else {
            String id = listSize.get(row).getId();
            String ma = txtMaSize.getText();
            String ten = txtSoSize.getText();
            SizeDomain cl = new SizeDomain(ma, Integer.parseInt(ten));
            String update = sizeService.update(cl, id);
            JOptionPane.showMessageDialog(this, update);
            listSize = sizeService.getAll();
            showDataSize(listSize);
        }
    }//GEN-LAST:event_btnUpdateMS1ActionPerformed

    private void btnAddMS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMS1ActionPerformed
        // TODO add your handling code here:
         String ma = gen("Sz");
        String soSize = txtSoSize.getText();
        
        SizeDomain cl = new SizeDomain(ma, Integer.parseInt(soSize));
        String add = sizeService.add(cl);
        JOptionPane.showMessageDialog(this, add);
        listSize = sizeService.getAll();
         showDataSize(listSize);
    }//GEN-LAST:event_btnAddMS1ActionPerformed

    private void tbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSizeMouseClicked
        // TODO add your handling code here:
        int row = tbSize.getSelectedRow();
        fillDataSize(row);
    }//GEN-LAST:event_tbSizeMouseClicked

    private void btnCLearMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearMSActionPerformed

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

    private void tbMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMSMouseClicked
        // TODO add your handling code here:
        int row = tbMS.getSelectedRow();
        fillDataMS(row);
    }//GEN-LAST:event_tbMSMouseClicked

    private void btnCLearCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearCLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearCLActionPerformed

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

    private void tbCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCLMouseClicked
        // TODO add your handling code here:
        int row = tbCL.getSelectedRow();
        fillDataChatLieu(row);
    }//GEN-LAST:event_tbCLMouseClicked

    private void btnCLearSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCLearSPActionPerformed

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

    private void tbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPMouseClicked
        // TODO add your handling code here:
        int row = tbSP.getSelectedRow();
        fillDataSanPham(row);
    }//GEN-LAST:event_tbSPMouseClicked

    private void btnCLearDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearDSPActionPerformed
        // TODO add your handling code here:
        txtMaDSP.setText("");
        txtTenDSP.setText("");
    }//GEN-LAST:event_btnCLearDSPActionPerformed

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

    private void tbDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDongSPMouseClicked
        // TODO add your handling code here:
        int row = tbDongSP.getSelectedRow();
        fillDataDongSP(row);
    }//GEN-LAST:event_tbDongSPMouseClicked

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
            java.util.logging.Logger.getLogger(ViewQLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQLSP().setVisible(true);
            }
        });
    }

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
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbCL;
    private javax.swing.JTable tbDongSP;
    private javax.swing.JTable tbMS;
    private javax.swing.JTable tbNhaSanXuat;
    private javax.swing.JTable tbSP;
    private javax.swing.JTable tbSize;
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
    // End of variables declaration//GEN-END:variables
}
