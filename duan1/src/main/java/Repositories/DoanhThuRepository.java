/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Utilities.DBContext;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import viewmodel.DoanhThuViewModel;

/**
 *
 * @author Phuong Bi
 */
public class DoanhThuRepository {
    //doanh thu của từng tháng theo năm hiện tại

    public ArrayList<DoanhThuViewModel> DTNamHienTai() throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select month(ngayTao)'Tháng',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)'Tổng doanh thu'\n"
                + "from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "			   where year(ngayTao) = year(getdate())\n"
                + "                group by ngayTao";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new DoanhThuViewModel(rs.getString("Tháng"), rs.getInt("Tổng số lượng"), rs.getBigDecimal("Tổng doanh thu")));

        }
        return n;

    }

    //doanh thu cua từng tháng trong năm => chọn năm hiển thị doanh thu từng tháng của năm đó
    public ArrayList<DoanhThuViewModel> theoNam(String nam) throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select month(ngayTao)'Tháng',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)'Tổng doanh thu'\n"
                + "from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "			   where year(ngayTao) = ?\n"
                + "                group by month(ngayTao)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nam);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new DoanhThuViewModel(rs.getString("Tháng"), rs.getInt("Tổng số lượng"), rs.getBigDecimal("Tổng doanh thu")));

        }
        return n;

    }

    //doanh thu từng ngày trong tháng
    public ArrayList<DoanhThuViewModel> theoTungNgayTrongThang(String nam, String thang) throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select ngayTao 'Ngay',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)'Tổng doanh thu'\n"
                + "from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "			   where year(ngayTao) = ? and month(ngayTao)= ?\n"
                + "                group by ngayTao";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nam);
        ps.setString(2, thang);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new DoanhThuViewModel(rs.getString("Ngay"), rs.getInt("Tổng số lượng"), rs.getBigDecimal("Tổng doanh thu")));

        }
        return n;

    }

    // số hóa đơn trong ngày
    public int soHoaDonTrongNgay() throws SQLException {
        int count = 0;

        Connection conn = DBContext.getConnection();
        String sql = "select count(id)  'Số lượng hóa đơn hôm nay' from hoadon\n"
                + "                where year(ngayTao) = year(getdate()) and month(ngayTao) = month(getdate()) and day(ngayTao) = day(getdate()) and trang_thai ='1'";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //số lượng sản phẩm đã bán trong ngày
    public int soLuongSPTrongNgay() throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "			select sum(so_luong_mua)  'Số lượng hóa đơn hôm nay' from hoadon join HoaDonChiTiet on HoaDon.id = HoaDonChiTiet.id_HoaDon\n"
                + "                where year(ngayTao) = year(getdate()) and month(ngayTao) = month(getdate()) and day(ngayTao) = day(getdate()) and trang_thai ='1'";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //lấy ra tổng doanh thu trong ngày
    public int tongDoanhThuNgay() throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "			select sum(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban)  'Doanh thu'\n"
                + "		from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + " join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + " join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "\n"
                + "                where year(ngayTao) = year(getdate()) and month(ngayTao) = month(getdate()) and day(ngayTao) = day(getdate()) and hoadon.trang_thai ='1'";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //thống kê biểu đồ
    //bieu do doanh thu theo nam hien tai
    public void bieuDoTheoNamHienTai(JPanel jp) throws SQLException {
        DoanhThuRepository doanhThuRepository = new DoanhThuRepository();
        List<DoanhThuViewModel> listDT = doanhThuRepository.DTNamHienTai();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listDT != null) {
            for (DoanhThuViewModel doanhThuBieuDo : listDT) {
                dataset.addValue(doanhThuBieuDo.getDoanhThu(), "Doanh thu", doanhThuBieuDo.getNgayThanhToan());

            }
        }

        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu".toUpperCase(),
                "Thời gian", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jp.getWidth(), 321));

        jp.removeAll();
        jp.setLayout(new CardLayout());
        jp.add(chartPanel);
        jp.validate();
        jp.repaint();
    }

    //bieu do thang theo tung nam
    public void bieuDoTheoNam(JPanel jp, String nam) throws SQLException {
        DoanhThuRepository doanhThuRepository = new DoanhThuRepository();
        List<DoanhThuViewModel> listDT = doanhThuRepository.theoNam(nam);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listDT != null) {
            for (DoanhThuViewModel doanhThuBieuDo : listDT) {
                dataset.addValue(doanhThuBieuDo.getDoanhThu(), "Doanh thu", doanhThuBieuDo.getNgayThanhToan());

            }
        }

        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu".toUpperCase(),
                "Thời gian", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jp.getWidth(), 321));

        jp.removeAll();
        jp.setLayout(new CardLayout());
        jp.add(chartPanel);
        jp.validate();
        jp.repaint();
    }

    public static void main(String[] args) throws SQLException {
        DoanhThuRepository d = new DoanhThuRepository();
        System.out.println(d.tongDoanhThuNgay());

    }
}
