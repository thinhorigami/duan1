/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import Domainmodel.KhuyenMai;
import Service.KhuyenMaiService;
import ViewModels.KhuyenMaiViewmodel;

import java.awt.Color;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author concu
 */
public class NewJFrameKhuyenMai extends javax.swing.JFrame {

    //SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");

    KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
    private DefaultTableModel defaultTableModel;

    public NewJFrameKhuyenMai() {
        initComponents();
        setLocationRelativeTo(null);

        hienTHi();
    }

    public void hienTHi() {
        try {
            DefaultTableModel model = (DefaultTableModel) tbKhuyenMai.getModel();
            model.setRowCount(0);
            List<KhuyenMaiViewmodel> khuyenMai = khuyenMaiService.layDSKM();
            for (KhuyenMaiViewmodel km : khuyenMai) {
                Object[] kms = new Object[]{
                    km.getId(),
                    km.getMa(),
                    km.getTenKM(),
                    km.getNgayBatDau(),
                    km.getNgayKetThuc(),
                    km.getMuc_giam_gia(),
                    km.getDonVi(),
                    km.getMoTa(),
                    km.getTrangThai() };
                model.addRow(kms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrameKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        lbID = new javax.swing.JLabel();
        rdHoatDong = new javax.swing.JRadioButton();
        rdHetHan = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        rdPhanTram = new javax.swing.JRadioButton();
        rdVND = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        dateBD = new com.github.lgooddatepicker.components.DatePicker();
        dateKT = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên", "Ngày bắt đầu", "Ngày kết thúc", "Mức giảm", "Đơn vị", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbKhuyenMai);

        lbID.setText("Tự động");

        buttonGroup2.add(rdHoatDong);
        rdHoatDong.setText("Hoat dong");

        buttonGroup2.add(rdHetHan);
        rdHetHan.setText("Het han");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        txtMa.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        jLabel2.setText("Tên chương trình:");

        jLabel3.setText("Mã:");

        jLabel4.setText("Thông tin chương trình");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));

        jLabel5.setText("Mức giảm:");

        jLabel6.setText("Ngày bắt đầu:");

        jLabel7.setText("Ngày kết thúc");

        buttonGroup1.add(rdPhanTram);
        rdPhanTram.setText("%");

        buttonGroup1.add(rdVND);
        rdVND.setText("VND");

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtMoTa);

        jLabel8.setText("Mô tả:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(rdVND, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(rdPhanTram))
                                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbID, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dateKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 135, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(rdHoatDong)
                                .addGap(4, 4, 4)
                                .addComponent(rdHetHan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLamMoi)))))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdVND)
                            .addComponent(rdPhanTram))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbID)
                        .addComponent(rdHetHan)
                        .addComponent(rdHoatDong))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnLamMoi)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       try{
           KhuyenMaiViewmodel khuyenMai = layTT();
            if (khuyenMaiService.ThemKhuyenMai(khuyenMai) == true) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                hienTHi();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrameKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        rdHoatDong.setSelected(false);
        rdHetHan.setSelected(false);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       try {
            // TODO add your handling code here:
            int index = tbKhuyenMai.getSelectedRow();
            String ID = tbKhuyenMai.getValueAt(index, 0).toString();
            khuyenMaiService.XoaKhuyenMai(Integer.parseInt(lbID.getText()));
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            hienTHi();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrameKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
       
        int index = tbKhuyenMai.getSelectedRow();
        String id = tbKhuyenMai.getValueAt(index, 0).toString();
        String ma = tbKhuyenMai.getValueAt(index, 1).toString();
        String Ten = tbKhuyenMai.getValueAt(index, 2).toString();
        String ngaybd = tbKhuyenMai.getValueAt(index, 3).toString();
        String ngaykt = tbKhuyenMai.getValueAt(index, 4).toString();
        String giamGia = tbKhuyenMai.getValueAt(index, 5).toString();
        String DonVi = tbKhuyenMai.getValueAt(index, 6).toString();
        String mota = tbKhuyenMai.getValueAt(index, 7).toString();
        String trangThai = tbKhuyenMai.getValueAt(index, 8).toString();

        txtMoTa.setText(mota);
        txtMa.setText(ma);
        txtName.setText(Ten);
        txtMucGiamGia.setText(giamGia);
        dateBD.setText(ngaybd);
        dateKT.setText(ngaykt);
        lbID.setText(id);
        lbID.setBackground(Color.red);
        
        if (DonVi.equalsIgnoreCase("true")) {
            rdVND.setSelected(true);
            rdPhanTram.setSelected(false);
        } else {
            rdVND.setSelected(false);
            rdPhanTram.setSelected(true);

        }
        
        if (trangThai.equalsIgnoreCase("Hoat dong")) {
            rdHoatDong.setSelected(true);
            rdHetHan.setSelected(false);
        } else {
            rdHoatDong.setSelected(false);
            rdHetHan.setSelected(true);

        }
    
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked
    public KhuyenMaiViewmodel layTT() {
        
        String maKM = txtMa.getText();
        String tenCT = txtName.getText();
        String ngayBD = dateBD.getDateStringOrEmptyString();
        String ngayKT = dateKT.getDateStringOrEmptyString();
        String maGG = txtMucGiamGia.getText();
        String moTa = txtMoTa.getText();
        String trangThai;
        if (rdHoatDong.isSelected()) {
            trangThai = "Hoat dong";
        } else {
            trangThai = "Het han";
        }
        
        Boolean donVi;
        if (rdVND.isSelected()) {
            donVi = true;
        } else {
            donVi = false;
        }
        return new KhuyenMaiViewmodel(0,maKM, tenCT, ngayBD, ngayKT, Integer.parseInt(maGG), donVi, moTa, trangThai);
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.github.lgooddatepicker.components.DatePicker dateBD;
    private com.github.lgooddatepicker.components.DatePicker dateKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbID;
    private javax.swing.JRadioButton rdHetHan;
    private javax.swing.JRadioButton rdHoatDong;
    private javax.swing.JRadioButton rdPhanTram;
    private javax.swing.JRadioButton rdVND;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtMucGiamGia;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
