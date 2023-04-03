/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Utilities.DBContext;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
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
import org.jfree.data.general.DefaultPieDataset;
import viewmodel.DoanhThuViewModel;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class DoanhThuRepository {
    //doanh thu của từng tháng theo năm hiện tại

    public ArrayList<DoanhThuViewModel> DTNamHienTai() throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select month(ngayTao)'Tháng',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.don_gia - KhuyenMai.don_vi )'Tổng doanh thu'\n"
                + "                from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + "                 join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + "                join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "                		   where year(ngayTao) = year(getdate())\n"
                + "                               group by ngayTao";
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
        String sql = "select month(ngayTao)'Tháng',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.don_gia - KhuyenMai.don_vi)'Tổng doanh thu'\n"
                + "                from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + "                 join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + "                 join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "               		   where year(ngayTao) = ?\n"
                + "                               group by month(ngayTao)";
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
        String sql = "select ngayTao 'Ngay',sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.don_gia - KhuyenMai.don_vi)'Tổng doanh thu'\n"
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
        String sql = "			select sum(HoaDonChiTiet.don_gia - KhuyenMai.don_vi)  'Doanh thu'\n"
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

    //tính doanh thu từ ngày .... => ngày....
    public ArrayList<DoanhThuViewModel> tuNgayDenNgay(String ngay1, String ngay2) throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select count(HoaDon.ID) 'Tổng số hóa đơn', sum(so_luong_mua) 'Tổng số lượng',sum(HoaDonChiTiet.don_gia - KhuyenMai.don_vi)'Tổng doanh thu'\n"
                + "                             from KhuyenMai join HoaDon on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + "                              join HoaDonChiTiet on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + "                               join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "                             		   where ngayTao  BETWEEN ? AND ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ngay1);
        ps.setString(2, ngay2);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new DoanhThuViewModel(rs.getString("Tổng số hóa đơn"), rs.getInt("Tổng số lượng"), rs.getBigDecimal("Tổng doanh thu")));

        }
        return n;

    }

    //số hóa đơn đã thanh toán
    public int soHoaDonDaThanhToan() throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "select count(hoadon.id)'So hoa don'\n"
                + "from hoadon\n"
                + "where trang_thai = 1";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //số hóa đơn chưa thanh toán
    public int soHoaDonChuaThanhToan() throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "select count(hoadon.id)'So hoa don'\n"
                + "from hoadon\n"
                + "where trang_thai = 0";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //số hóa đơn đã thanh toán
    public int soHoaDonDaThanhToanTheoNam(String nam) throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "select count(hoadon.id)'So hoa don'\n"
                + "                from hoadon\n"
                + "                where trang_thai = 1 and year(ngayTao) = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nam);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //số hóa đơn chưa thanh toán
    public int soHoaDonChuaThanhToanTheoNam(String nam) throws SQLException {
        int count = 0;
        Connection conn = DBContext.getConnection();
        String sql = "select count(hoadon.id)'So hoa don'\n"
                + "                from hoadon\n"
                + "                where trang_thai = 0 and year(ngayTao) = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nam);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count = rs.getInt(1);

        }
        return count;

    }

    //bieu do thong ke hoa don
    public void thongKeHoaDon(JPanel jp) throws SQLException {
        DoanhThuRepository doanhThuRepository = new DoanhThuRepository();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Hóa đơn chưa thanh toán", doanhThuRepository.soHoaDonChuaThanhToan());
        dataset.setValue("Hóa đơn đã thanh toán", doanhThuRepository.soHoaDonDaThanhToan());

        JFreeChart barChart = ChartFactory.createPieChart("Biểu đồ hóa đơn", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jp.getWidth(), 321));

        jp.removeAll();
        jp.setLayout(new CardLayout());
        jp.add(chartPanel);
        jp.validate();
        jp.repaint();
    }

    //bieu do thong ke hoa don theo nam
    public void thongKeHoaDonTheoNam(JPanel jp, String nam) throws SQLException {
        DoanhThuRepository doanhThuRepository = new DoanhThuRepository();
        List<DoanhThuViewModel> listDT = doanhThuRepository.DTNamHienTai();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Hóa đơn chưa thanh toán", doanhThuRepository.soHoaDonChuaThanhToanTheoNam(nam));
        dataset.setValue("Hóa đơn đã thanh toán", doanhThuRepository.soHoaDonDaThanhToanTheoNam(nam));

        JFreeChart barChart = ChartFactory.createPieChart("Biểu đồ hóa đơn", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jp.getWidth(), 321));

        jp.removeAll();
        jp.setLayout(new CardLayout());
        jp.add(chartPanel);
        jp.validate();
        jp.repaint();
    }

    //lay nam 
    public ArrayList<DoanhThuViewModel> layNam() throws SQLException {
        ArrayList<DoanhThuViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select year(ngayTao) 'Nam' from hoadon\n"
                + "group by year(ngayTao) order by year(ngayTao) desc ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new DoanhThuViewModel(rs.getString("Nam")));

        }
        return n;

    }

    //thong ke so luong san pham sap het hang
    public ArrayList<SanPhamCTViewModel> soLuongSPSapHetHang() throws SQLException {
        ArrayList<SanPhamCTViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select sanpham.ma_sp 'Masp', SanPham.ten_sp 'Tensp',ChatLieu.ten_chat_lieu 'TenChatLieu',mausac.ten_mau 'Tenmau',size.so_size 'sosize',\n"
                + "DongSanPham.ten_dong 'tendongsp', NhaSanXuat.ten_nsx 'TenNSX',gia_nhap,gia_ban,so_luong_ton\n"
                + "from sanpham join chitietsanpham on sanpham.ID = ChiTietSanPham.id_sp\n"
                + "join MauSac on ChiTietSanPham.id_mau_sac = MauSac.ID\n"
                + "join chatlieu on ChiTietSanPham.id_chat_lieu = ChatLieu.ID\n"
                + "join size on ChiTietSanPham.id_size = size.ID\n"
                + "join DongSanPham on DongSanPham.id = ChiTietSanPham.id_dong_sp\n"
                + "join NhaSanXuat on NhaSanXuat.ID = ChiTietSanPham.id_nsx\n"
                + "where so_luong_ton <= 10";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new SanPhamCTViewModel(rs.getString("Masp"),
                    rs.getString("Tensp"), rs.getString("TenChatLieu"),
                    rs.getString("Tenmau"), rs.getString("sosize"), rs.getString("tendongsp"), rs.getString("TenNSX"), rs.getInt("so_luong_ton"), rs.getBigDecimal("gia_nhap"), rs.getBigDecimal("gia_ban")));

        }
        return n;

    }

    public static void main(String[] args) throws SQLException {
        DoanhThuRepository d = new DoanhThuRepository();
//        System.out.println(d.soHoaDonChuaThanhToanTheoNam("2020"));
        System.out.println(d.soLuongSPSapHetHang());

    }
}
