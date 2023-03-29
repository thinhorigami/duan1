/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Domainmodel.ChatLieuDomain;
import Domainmodel.ChiTiet;
import Domainmodel.ChiTietSanPham;
import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import Repositories.ChiTietRepo;
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
import Utilities.DBContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import viewmodel.SanPhamCTViewModel;
import java.sql.SQLException;

/**
 *
 * @author Phuong Bi
 */
public class ImportDataFromExcel extends javax.swing.JFrame {

    private ChiTietRepo ctrepo = new ChiTietRepo();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private NsxService nsxService = new NsxServiceImpl();

    private MauSacService mauSacService = new MauSacServiceImpl();

    private DongSanPhamService dongSanPhamService = new DongSPServiceImpl();

    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();

    private SizeService service = new SizeServiceImpl();
    DefaultTableModel model;

    //lấy tên sp
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

    //lấy tên nhà sản xuất
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

    //lấy tên màu sắc
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

    //lấy tên dòng sản phẩm
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

    //lấy tên chất liệu
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

    //lấy tên size
    public String layIDSize(String tenCV) {
        String idCV = null;
        ArrayList<SizeDomain> list = (ArrayList<SizeDomain>) service.getAll();
        for (SizeDomain chucVu : list) {
            if (chucVu.getSoSize().equals(tenCV)) {
                idCV = chucVu.getId();
            }

        }
        return idCV;

    }

    /**
     * Creates new form ImportDataFromExcel
     */
    public ImportDataFromExcel() {
        initComponents();
        setLocationRelativeTo(null);
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
        jButton1 = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Improt(Excel)");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Nhà sản xuất", "Màu sắc", "Dòng sản phẩm", "Chất liệu", "Size", "Mô tả", "Số lượng tồn", "Giá nhập", "Giá bán", "Ảnh", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tbbang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        model = (DefaultTableModel) tbbang.getModel();

        model.setColumnCount(0);

        model.addColumn("Tên sản phẩm");
        model.addColumn("Tên NSX");
        model.addColumn("Tên màu");
        model.addColumn("Dòng sp");
        model.addColumn("Chất liệu");
        model.addColumn("Size");
        model.addColumn("Mô tả");
        model.addColumn("Số lượng tồn");
        model.addColumn("Giá nhập");
        model.addColumn("Giá bán");
        model.addColumn("Ảnh");
        model.addColumn("Trạng thái");
        model.setRowCount(0);
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;

        String currentDirectoryPath = "C:\\Users\\Phuong Bi\\Documents";
        JFileChooser excelFileChooserImport = new JFileChooser(currentDirectoryPath);
        int excelChooser = excelFileChooserImport.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            File excelFile = excelFileChooserImport.getSelectedFile();
            try {
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportWorkBook = new XSSFWorkbook(excelBIS);

                XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);

                for (int i = 0; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelRow = excelSheet.getRow(i);
                    XSSFCell cell1 = excelRow.getCell(0);
                    XSSFCell cell2 = excelRow.getCell(1);
                    XSSFCell cell3 = excelRow.getCell(2);
                    XSSFCell cell4 = excelRow.getCell(3);
                    XSSFCell cell5 = excelRow.getCell(4);
                    XSSFCell cell6 = excelRow.getCell(5);
                    XSSFCell cell7 = excelRow.getCell(6);
                    XSSFCell cell8 = excelRow.getCell(7);
                    XSSFCell cell9 = excelRow.getCell(8);
                    XSSFCell cell10 = excelRow.getCell(9);
                    XSSFCell cell11 = excelRow.getCell(10);
                    XSSFCell cell12 = excelRow.getCell(11);

                    model.addRow(new Object[]{cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell11, cell12});

                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImportDataFromExcel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ImportDataFromExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:

        int insertedRows = 0;
        int row = tbbang.getRowCount();
        ChiTiet ct = new ChiTiet();
        for (int i = 0; i < row; i++) {
            String ten = layIDSanPham(model.getValueAt(i, 0).toString());
            String nsx = layIDNSX(model.getValueAt(i, 1).toString());
            String mauSac = layIDMauSac(model.getValueAt(i, 2).toString());
            String dongSP = layIDDongSP(model.getValueAt(i, 3).toString());
            String chatLieu = layIDChatLieu(model.getValueAt(i, 4).toString());

//            String size = layIDSize(model.getValueAt(i, 5).toString());
//            String dob[] = size.split("\\.");
//            String part1 = dob[0];
//            System.out.println(size);
            String size = model.getValueAt(i, 5).toString();
            String dob[] = size.split("\\.");
            String part1 = dob[0];
//            System.out.println(part1);
            String layIDsize = layIDSize(part1);
//            System.out.println(layIDsize);

            String moTa = model.getValueAt(i, 6).toString();
            String soLuongTon = model.getValueAt(i, 7).toString();
            String dob1[] = soLuongTon.split("\\.");
            String part2 = dob1[0];
//            System.out.println(part2);
            String giaNhap = model.getValueAt(i, 8).toString();
            String giaBan = model.getValueAt(i, 9).toString();
            String anh = model.getValueAt(i, 10).toString();
            String trangThai = model.getValueAt(i, 11).toString();
            String dob3[] = trangThai.split("\\.");
            String part3 = dob3[0];
//            System.out.println(part3);
            try {
                ct.setIdSP(ten);
                ct.setIdNSX(nsx);
                ct.setIdMauSac(mauSac);
                ct.setDongSP(dongSP);
                ct.setChatLieu(chatLieu);
                ct.setSize(layIDsize);
                ct.setMoTa(moTa);
                ct.setSoLuongTon(part2);
                ct.setGiaNhap(giaNhap);
                ct.setGiaBan(giaBan);
                ct.setAnh(anh);
                ct.setTrangThai(part3);
                boolean kt = ctrepo.add(ct);
            } catch (Exception e) {
            }

        }
        JOptionPane.showMessageDialog(this, "Them thanh cong");


    }//GEN-LAST:event_btnLuuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

     


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ImportDataFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportDataFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportDataFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportDataFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportDataFromExcel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbang;
    // End of variables declaration//GEN-END:variables
}
