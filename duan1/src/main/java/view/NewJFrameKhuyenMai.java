/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import ViewModels.KhuyenMaiViewmodel;
import Domainmodel.KhuyenMai;
import ServiceImpl.KhuyenMaiService;
import Service.QLKhuyenMai;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    QLKhuyenMai khuyenMaiService = new KhuyenMaiService();
    private DefaultTableModel defaultTableModel;

    public NewJFrameKhuyenMai() {
        initComponents();
        setLocationRelativeTo(null);

        loadTable(khuyenMaiService.getListKhuyenMai());
    }

    private void loadTable(ArrayList<KhuyenMai> list) {
        defaultTableModel = (DefaultTableModel) tbKhuyenMai.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuyenMai km : list) {
            defaultTableModel.addRow(new Object[]{
                km.getId(),
                km.getMa(),
                km.getTenKM(),
                km.getNgayBatDau(),
                km.getNgayKetThuc(),
                km.getMuc_giam_gia(),
                km.getDonVi() == true ? "VND" : "%",
                km.getMoTa(),
                km.getTrangThai()
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        rdPhanTram = new javax.swing.JRadioButton();
        rdVND = new javax.swing.JRadioButton();
        dateKT = new com.github.lgooddatepicker.components.DatePicker();
        lbID = new javax.swing.JLabel();
        rdHoatDong = new javax.swing.JRadioButton();
        rdHetHan = new javax.swing.JRadioButton();
        dateBD = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        txtMa.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        jLabel2.setText("Tên chương trình:");

        jLabel3.setText("Mã:");

        jLabel5.setText("Mức giảm:");

        jLabel7.setText("Ngày kết thúc:");

        rdPhanTram.setText("%");

        rdVND.setText("VND");

        lbID.setText("Tự động");

        rdHoatDong.setText("Hoat dong");

        rdHetHan.setText("Het han");

        jLabel6.setText("Ngày bắt đầu:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateKT, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(92, 92, 92)
                                    .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdVND, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdPhanTram))
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbID)
                                .addGap(18, 18, 18)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(126, 126, 126)
                            .addComponent(rdHoatDong)
                            .addGap(4, 4, 4)
                            .addComponent(rdHetHan)
                            .addGap(33, 33, 33)))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdVND)
                        .addComponent(rdPhanTram))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbID)
                        .addComponent(rdHetHan)
                        .addComponent(rdHoatDong))
                    .addGap(22, 22, 22)))
        );

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
        tbKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbKhuyenMai);

        jLabel8.setText("Mô tả:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMoTa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtMoTa);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addGap(32, 32, 32))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addContainerGap(308, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 21, Short.MAX_VALUE)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(btnThem)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        lbID.setText(id);
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

        if (trangThai.equalsIgnoreCase("Hoat dong")) {
            rdHoatDong.setSelected(true);
            rdHetHan.setSelected(false);
        } else {
            rdHoatDong.setSelected(false);
            rdHetHan.setSelected(true);

        }
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhuyenMai kmv = new KhuyenMai();
        String maKM = txtMa.getText();
        String name = txtName.getText().replaceAll("\\s+", " ");
        String start = dateBD.getDateStringOrEmptyString();
        String end = dateKT.getDateStringOrEmptyString();
        String giamGia = txtMucGiamGia.getText();
        String moTa = txtMoTa.getText();
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
            } else if (!txtMucGiamGia.getText().trim().matches("[0-9]+") || Integer.parseInt(txtMucGiamGia.getText().trim()) > 100) {
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
        kmv.setMuc_giam_gia(Integer.parseInt(giamGia));
        kmv.setMoTa(moTa);

        kmv.setDonVi(rdVND.isSelected() ? true : false);
        kmv.setTrangThai(rdHoatDong.isSelected() ? "Hoat dong" : "Het han");

        String result = khuyenMaiService.addKhuyenMai(kmv);
        JOptionPane.showMessageDialog(this, result);
        loadTable(khuyenMaiService.getListKhuyenMai());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            int index = tbKhuyenMai.getSelectedRow();
            String ID = tbKhuyenMai.getValueAt(index, 0).toString();
            khuyenMaiService.XoaKhuyenMai(Integer.parseInt(lbID.getText()));
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadTable(khuyenMaiService.getListKhuyenMai());
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrameKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        rdHoatDong.setSelected(false);
        rdHetHan.setSelected(false);
    }//GEN-LAST:event_btnLamMoiActionPerformed
    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameKhuyenMai().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
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
