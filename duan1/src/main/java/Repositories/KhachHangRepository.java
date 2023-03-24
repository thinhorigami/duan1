/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.KhachHang;
import Utilities.DBContext;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Phuong Bi
 */
public class KhachHangRepository {

    public ArrayList<KhachHang> getAll() throws SQLException {
        ArrayList<KhachHang> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from khachhang";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new KhachHang(rs.getString("id"),
                    rs.getString("maKH"),
                    rs.getString("tenKH"),
                    rs.getString("gioiTinh"),
                    rs.getString("diaChi"),
                    rs.getString("ngaySinh"),
                    rs.getString("dienThoai"),
                    rs.getInt("trangThai"),
                    rs.getString("email"),
                    rs.getString("thanhPho")));

        }
        return n;

    }

    public boolean add(KhachHang n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO KhachHang\n"
                    + "                  (maKH, tenKH, gioiTinh, diaChi, ngaySinh, dienThoai, trangThai, email, thanhPho)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMa());
            ps.setString(2, n.getTen());
            ps.setString(3, n.getGioiTinh());
            ps.setString(4, n.getDiaChi());
            ps.setString(5, n.getNgaySinh());
            ps.setString(6, n.getDienThoai());
            ps.setInt(7, n.getTrangThai());
            ps.setString(8, n.getEmail());
            ps.setString(9, n.getThanhPho());
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }

    }

    public boolean update(String ma, KhachHang n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE KhachHang\n"
                    + "SET          tenKH =?, gioiTinh =?, diaChi =?,"
                    + " ngaySinh =?, dienThoai =?, trangThai =?,"
                    + " email =?, thanhPho =? where maKH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, n.getMa());
            ps.setString(1, n.getTen());
            ps.setString(2, n.getGioiTinh());
            ps.setString(3, n.getDiaChi());
            ps.setString(4, n.getNgaySinh());
            ps.setString(5, n.getDienThoai());
            ps.setInt(6, n.getTrangThai());
            ps.setString(7, n.getEmail());
            ps.setString(8, n.getThanhPho());
            ps.setString(9, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean delete(String ma) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete khachhang where maKH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        KhachHangRepository k = new KhachHangRepository();
//        System.out.println(k.getAll());
        KhachHang kh = new KhachHang();
//        kh.setMa("KH10");
        kh.setTen("Phuong");
        kh.setDiaChi("Ha Noi");
        kh.setEmail("phuong123@gmail.com");
        kh.setThanhPho("Ha Noi ");
//        k.update("KH10",kh);
        k.delete("KH10");
    }
}
