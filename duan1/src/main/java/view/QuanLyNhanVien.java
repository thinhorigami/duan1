/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Domainmodel.NhanVien;
import Service.ChucVuService;
import Service.NhanVienService;
import ServiceImpl.ChucVuServiceImpl;
import ServiceImpl.NhanVienServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import viewmodel.ChucVuviewModel;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author nguye
 */
public class QuanLyNhanVien extends javax.swing.JPanel {

    NhanVienService nhan_vien_service;
    ChucVuService chuc_vu_service;
    NhanVien nhan_vien; // nhân viên đang được thao tác (CRUD) 

    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() throws Exception {
        initComponents();
        this.nhan_vien = new NhanVien();
        this.nhan_vien_service = new NhanVienServiceImpl();
        this.chuc_vu_service = new ChucVuServiceImpl();
        emptyText();
        this.initData();;
    }

    public void initData() throws Exception {
        NhanVienViewModel table = new NhanVienViewModel();
        table.fillData(new NhanVienServiceImpl().getAll());
        table_data.setModel(table.getModel());

        ChucVuviewModel cvvm = new ChucVuviewModel();
        this.chuc_vu.setModel(cvvm.fillComboBox());
    }

    public void emptyText() {
        this.ten.setText("");
        this.ma.setText("");
        this.dia_chi.setText("");
        this.email.setText("");
        this.ngay_sinh.setText("");
        this.so_dien_thoai.setText("");
    }

    public void fillText(NhanVien _nv) {
        this.ma.setText(_nv.getMa());
        this.ten.setText(_nv.getTen());
        this.email.setText(_nv.getEmail());
        this.dia_chi.setText(_nv.getDiaChi());
        if (_nv.getGioiTinh().compareTo("Nam") == 0) {
            this.nam.setSelected(true);
        } else {
            this.nu.setSelected(true);
        }
        this.so_dien_thoai.setText(_nv.getDienThoai());
        this.ngay_sinh.setText(new SimpleDateFormat("dd-MM-yyyy").format(_nv.getNgaySinh()));

        this.nhan_vien_service.getChucVu(_nv)
                .ifPresent((o) -> {
                    chuc_vu.setSelectedItem(o.getTen());
                });
    }

    public void mappText() throws ParseException {
        this.nhan_vien.setTen(this.ten.getText());
        this.nhan_vien.setMa(this.ma.getText());
        this.nhan_vien.setEmail(this.email.getText());
        this.nhan_vien.setDiaChi(this.dia_chi.getText());
        this.nhan_vien.setGioiTinh(this.nam.isSelected() ? "Nam" : "Nữ");
        this.nhan_vien.setNgaySinh(new SimpleDateFormat("MM-dd-yyyy")
                .parse(this.ngay_sinh.getText()));
        this.nhan_vien.setTrangThai(this.chuc_vu.getSelectedIndex() + 1);
        this.chuc_vu_service.getByTenChucVu(this.chuc_vu
                .getSelectedItem().toString())
                .ifPresent((o) -> {
                    this.nhan_vien.setIdChaucVu(o.getId());
                });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        ten = new javax.swing.JTextField();
        ma = new javax.swing.JTextField();
        dia_chi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        so_dien_thoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ngay_sinh = new javax.swing.JTextField();
        chuc_vu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        trang_thai = new javax.swing.JComboBox<>();

        table_data.setModel(new javax.swing.table.DefaultTableModel(
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
        table_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_data);

        jLabel1.setText("mã nhân viên");

        jLabel2.setText("tên nhân viên");

        buttonGroup1.add(nam);
        nam.setSelected(true);
        nam.setText("Nam");

        buttonGroup1.add(nu);
        nu.setText("Nữ");

        jLabel3.setText("giới tính");

        jLabel4.setText("email");

        jLabel5.setText("số điện thoại");

        jLabel6.setText("trạng thái");

        jLabel7.setText("địa chỉ");

        jLabel8.setText("ngay_sinh");

        chuc_vu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("chức vụ");

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        trang_thai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(ten, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(trang_thai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nam)
                                .addGap(18, 18, 18)
                                .addComponent(nu))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(email)
                            .addComponent(jLabel5)
                            .addComponent(so_dien_thoai, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(chuc_vu, 0, 190, Short.MAX_VALUE)
                                    .addComponent(ngay_sinh))
                                .addGap(12, 386, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dia_chi, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(ma, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(521, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nam)
                    .addComponent(nu)
                    .addComponent(jButton1)
                    .addComponent(dia_chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngay_sinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(so_dien_thoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chuc_vu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trang_thai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(360, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
        if (this.table_data.getSelectedRowCount() != 1) {
            return;
        }
        
        this.nhan_vien_service
                .getByMa(this.table_data
                        .getValueAt(this.table_data.getSelectedRow(), 0)
                        .toString())
                .ifPresent((o) -> {
                    this.nhan_vien = o;
                    this.fillText(this.nhan_vien);
                });
        System.out.println(this.nhan_vien.getId());
    }//GEN-LAST:event_table_dataMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.mappText();
            if (nhan_vien_service.update(this.nhan_vien)){
                JOptionPane.showMessageDialog(null, "update thanh cong");
                this.initData();
            }
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> chuc_vu;
    private javax.swing.JTextField dia_chi;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ma;
    private javax.swing.JRadioButton nam;
    private javax.swing.JTextField ngay_sinh;
    private javax.swing.JRadioButton nu;
    private javax.swing.JTextField so_dien_thoai;
    private javax.swing.JTable table_data;
    private javax.swing.JTextField ten;
    private javax.swing.JComboBox<String> trang_thai;
    // End of variables declaration//GEN-END:variables
}
