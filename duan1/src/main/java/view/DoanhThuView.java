/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Service.DoanhThuService;
import ServiceImpl.DoanhThuServiceImpl;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import viewmodel.DoanhThuViewModel;

/**
 *
 * @author Phuong Bi
 */
public class DoanhThuView extends javax.swing.JPanel {

    private DoanhThuService doanhThuService = new DoanhThuServiceImpl();
    DefaultTableModel model = new DefaultTableModel();

    public void DTNamHienTai() {
        ArrayList<DoanhThuViewModel> dt = doanhThuService.DTNamHienTai();
        model = (DefaultTableModel) tbbangDoanhThuThang.getModel();
        model.setColumnCount(0);
        model.addColumn("Tháng");
        model.addColumn("Số lượng");
        model.addColumn("Doanh thu");
        model.setRowCount(0);
        for (DoanhThuViewModel doanhThu : dt) {
            model.addRow(new Object[]{
                doanhThu.getNgayThanhToan(), doanhThu.getSoLuong(), doanhThu.getDoanhThu()
            });

        }

    }

    //load table tìm kiếm theo năm
    public void DTTheoNam(String nam) {
        ArrayList<DoanhThuViewModel> dt = doanhThuService.theoNam(nam);
        model = (DefaultTableModel) tbbangDoanhThuThang.getModel();
        model.setColumnCount(0);
        model.addColumn("Tháng");
        model.addColumn("Số lượng");
        model.addColumn("Doanh thu");
        model.setRowCount(0);
        for (DoanhThuViewModel doanhThu : dt) {
            model.addRow(new Object[]{
                doanhThu.getNgayThanhToan(), doanhThu.getSoLuong(), doanhThu.getDoanhThu()
            });

        }

    }

    //load table tìm kiếm doanh thu theo từng ngày trong tháng
    public void theoTungNgay(String nam, String thang) {
        ArrayList<DoanhThuViewModel> dt = doanhThuService.theoTungNgayTrongThang(nam, thang);
        model = (DefaultTableModel) tbtheoTungNgayTrongThang.getModel();
        model.setColumnCount(0);
        model.addColumn("Ngày");
        model.addColumn("Số lượng");
        model.addColumn("Doanh thu");
        model.setRowCount(0);
        for (DoanhThuViewModel doanhThu : dt) {
            model.addRow(new Object[]{
                doanhThu.getNgayThanhToan(), doanhThu.getSoLuong(), doanhThu.getDoanhThu()
            });

        }

    }

    //tổng doanh thu năm
    public void tong() {

        DecimalFormat x = new DecimalFormat("###,###,###");
        String nam = txttimKiemNamBaoCao.getText();
        float tong = 0;
        for (int i = 0; i < tbbangDoanhThuThang.getRowCount(); i++) {
            tong += Double.parseDouble(tbbangDoanhThuThang.getValueAt(i, 2).toString());

        }
        jLabelTongDoanhThuNam.setText("Tổng doanh thu năm " + nam + " :" + x.format(tong) + " " + "VND");
    }

    //lấy năm hiện tại
    public void layNamHienTai() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String format = simpleDateFormat.format(date);
        txttimKiemNamBaoCao.setText(format);
        txttimKiemNamBieuDo.setText(format);

    }

    //số lượng hóa đơn homo nay
    public void soLuongHoaDon() {
        int soHoaDon = doanhThuService.soHoaDonTrongNgay();
        jLabelsoLuongHoaDon.setText("Số hóa đơn :" + soHoaDon);
    }

    //số lượng sản phẩm đã bán trong ngày
    public void soLuongSP() {
        int soSP = doanhThuService.soLuongSPTrongNgay();
        jLabelsoSP.setText("Số sản phẩm đã bán :" + soSP);
    }

    //tổng doanh thu hôm nay
    public void tongDoanhThu() {
        int doanhThu = doanhThuService.tongDoanhThuNgay();
        jLabelTongDoanhThu.setText("Số sản phẩm đã bán : " + doanhThu + " " + "VND");
    }

    //tìm kiếm theo ngày từ ... đến ...
//    public void showData(String d1, String d2) throws SQLException {
//        Connection conn = DBContext.getConnection();
//        PreparedStatement st;
//        ResultSet rs;
//
//        try {
//            if (d1.equals("") || d2.equals("")) {
//                st = conn.prepareStatement("select ngayTao 'Ngay',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)'Tổng doanh thu'\n"
//                        + "from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
//                        + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
//                        + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
//                        + "                group by ngayTao");
//            } else {
//                st = conn.prepareStatement("select ngayTao 'Ngay',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)'Tổng doanh thu'\n"
//                        + "from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
//                        + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
//                        + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
//                        + "			  where ngayTao  between ? and ?\n"
//                        + "                group by ngayTao");
//                st.setString(1, d1);
//                st.setString(2, d2);
//            }
//            rs = st.executeQuery();
//           
//            DefaultTableModel m = (DefaultTableModel) tbbangDoanhThuThang.getModel();
//            
//            Object[] row;
//            
//            while(rs.next()) {
//                row = new Object[3];
//                row[0] = rs.getString(1);
//                row[1] = rs.getInt(2);
//                row[2] = rs.getBigDecimal(3);
//                
//                m.addRow(row);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    /**
     * Creates new form DoanhThuView
     */
    public DoanhThuView() {
        initComponents();
        DTNamHienTai();
        layNamHienTai();
        tong();
        soLuongHoaDon();
        soLuongSP();
        tongDoanhThu();
        doanhThuService.bieuDoTheoNamHienTai(jPanelBieuDo);
        
     

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
        jLabelsoLuongHoaDon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelsoSP = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelTongDoanhThu = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txttimKiemNamBaoCao = new javax.swing.JTextField();
        jLabelTongDoanhThuNam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbangDoanhThuThang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtheoTungNgayTrongThang = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanelBieuDo = new javax.swing.JPanel();
        btnnam = new javax.swing.JButton();
        txttimKiemNamBieuDo = new javax.swing.JTextField();

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        jLabelsoLuongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelsoLuongHoaDon.setText("Số hóa đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabelsoLuongHoaDon)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelsoLuongHoaDon)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        jLabelsoSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelsoSP.setText("Số lượng sản phẩm đã bán");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelsoSP)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelsoSP)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        jLabelTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTongDoanhThu.setText("Doanh thu hôm nay");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelTongDoanhThu)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelTongDoanhThu)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Năm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelTongDoanhThuNam.setText("Tổng doanh thu năm");

        tbbangDoanhThuThang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbangDoanhThuThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangDoanhThuThangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbangDoanhThuThang);

        tbtheoTungNgayTrongThang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbtheoTungNgayTrongThang);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(txttimKiemNamBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTongDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                                .addGap(90, 90, 90))
                            .addComponent(jScrollPane2))
                        .addGap(76, 76, 76))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttimKiemNamBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTongDoanhThuNam))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Báo cáo doanh thu", jPanel6);

        jPanelBieuDo.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanelBieuDoLayout = new javax.swing.GroupLayout(jPanelBieuDo);
        jPanelBieuDo.setLayout(jPanelBieuDoLayout);
        jPanelBieuDoLayout.setHorizontalGroup(
            jPanelBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBieuDoLayout.setVerticalGroup(
            jPanelBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        btnnam.setText("Năm");
        btnnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnam)
                .addGap(38, 38, 38)
                .addComponent(txttimKiemNamBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnam)
                    .addComponent(txttimKiemNamBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanelBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Biểu đồ doanh thu", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DTTheoNam(txttimKiemNamBaoCao.getText());
        tong();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbbangDoanhThuThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangDoanhThuThangMouseClicked
        // TODO add your handling code here:
        int index = tbbangDoanhThuThang.getSelectedRow();
        theoTungNgay(txttimKiemNamBaoCao.getText(), tbbangDoanhThuThang.getValueAt(index, 0).toString());

    }//GEN-LAST:event_tbbangDoanhThuThangMouseClicked

    private void btnnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnamActionPerformed
        // TODO add your handling code here:
        doanhThuService.bieuDoTheoNam(jPanelBieuDo, txttimKiemNamBieuDo.getText());
    }//GEN-LAST:event_btnnamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnam;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabelTongDoanhThu;
    private javax.swing.JLabel jLabelTongDoanhThuNam;
    private javax.swing.JLabel jLabelsoLuongHoaDon;
    private javax.swing.JLabel jLabelsoSP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelBieuDo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbbangDoanhThuThang;
    private javax.swing.JTable tbtheoTungNgayTrongThang;
    private javax.swing.JTextField txttimKiemNamBaoCao;
    private javax.swing.JTextField txttimKiemNamBieuDo;
    // End of variables declaration//GEN-END:variables
}
