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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

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

        jLabel7.setText("Ngày kết thúc:");

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

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("*");

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("*");

        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setText("*");

        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("*");

        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("*");

        jLabel16.setText("Trạng thái:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
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
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel10))
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbID, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel9)
                                                .addGap(10, 10, 10))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dateKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)))
                                .addGap(0, 135, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdHoatDong)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdHetHan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLamMoi))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdVND)
                                .addComponent(rdPhanTram))
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(dateBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(dateKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            loadTable(khuyenMaiService.getListKhuyenMai());
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
        return new KhuyenMaiViewmodel(0, maKM, tenCT, ngayBD, ngayKT, Integer.parseInt(maGG), donVi, moTa, trangThai);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
