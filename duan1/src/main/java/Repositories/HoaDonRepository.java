/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.HoaDon;
import Domainmodel.KhachHang;
import Domainmodel.KhuyenMai;
import Domainmodel.NhanVien;
import Utilities.DBContext;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author 84982
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.ma_khuyen_mai\n"
                + "from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(7));
                HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ArrayList<HoaDonViewModel> hoaDonCT(String idHoaDon) throws SQLException {
        ArrayList<HoaDonViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select HoaDonChiTiet.ma_HoaDonCT 'Mã hóa đơn chi tiết', SanPham.ma_sp 'Mã sản phẩm',\n"
                + "				SanPham.ten_sp 'Tên sản phẩm',HoaDonChiTiet.so_luong_mua 'Số lượng', ChiTietSanPham.gia_ban'Giá bán',\n"
                + "				HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban 'Thanh tien'\n"
                + "				from HoaDon join HoaDonChiTiet on HoaDon.ID = HoaDonChiTiet.id_HoaDon\n"
                + "				join ChiTietSanPham on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "				join SanPham on SanPham.ID = ChiTietSanPham.id_sp where maHoaDon =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idHoaDon);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new HoaDonViewModel(rs.getString("Mã hóa đơn chi tiết"), rs.getString("Mã sản phẩm"),
                    rs.getString("Tên sản phẩm"), rs.getInt("Số lượng"), rs.getBigDecimal("Giá bán"), rs.getBigDecimal("Thanh tien")));

        }
        return n;

    }

 

    public ArrayList<String> getLisNgayTao() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoadon.ngayTao from HoaDon";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String str = rs.getString(1);
                list.add(str);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<String> getLisNgayThanhToan() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoadon.ngayThanhToan from HoaDon";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String str = rs.getString(1);
                list.add(str);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        HoaDonRepository h = new HoaDonRepository();
        System.out.println(h.hoaDonCT("C3C4457C-C1DA-487B-A0B8-8AAD7157C3EA"));
    }
    
     public List<HoaDon> searchTT(int trangThai) {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.ma_khuyen_mai\n" +
"                 from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai where HoaDon.trang_thai = ?";
              
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
           ps.setObject(1,trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(7));
                 HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
               
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
   
    public List<HoaDon> searchNgayTao(String ngayTao) {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.ma_khuyen_mai\n" +
"                 from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai where ngayTao =?";
              
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
           ps.setObject(1,ngayTao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(7));
                 HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
               
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
       public List<HoaDon> searchNgayThanhToan(String ngayTT) {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.ma_khuyen_mai\n" +
"                 from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai where ngayThanhToan =?";
              
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
           ps.setObject(1,ngayTT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(7));
                 HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
               
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
 
 
 public List<HoaDon> search(String ma) {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.ma_khuyen_mai\n" +
"                 from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai where maHoaDon like CONCAT('%', ?,'%')";
              
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
           ps.setObject(1,ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getString(7));
                HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
 
 

}
