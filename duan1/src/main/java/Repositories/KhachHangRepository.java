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
            n.add(new KhachHang(rs.getString("id"), rs.getString("ma"),
                    rs.getString("ten"), rs.getString("gioi_tinh"),
                    rs.getString("dia_chi"), rs.getString("ngay_sinh"),
                    rs.getString("so_dien_htoai"), rs.getString("trang_thai")));

        }
        return n;

    }

    public boolean add(KhachHang n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO KhachHang\n"
                    + "                  (ma, ten, gioi_tinh, dia_chi, ngay_sinh, so_dien_htoai, trang_thai)\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMa());
            ps.setString(2, n.getTen());
            ps.setString(3, n.getGioiTinh());
            ps.setString(4, n.getDiaChi());
            ps.setString(5,  n.getNgaySinh());
            ps.setString(6, n.getDienThoai());
            ps.setString(7, n.getTrangThai());
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
                    + "SET          ten =?, gioi_tinh =?, dia_chi =?, ngay_sinh =?, so_dien_htoai =?, trang_thai =? where ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, n.getMa());
            ps.setString(1, n.getTen());
            ps.setString(2, n.getGioiTinh());
            ps.setString(3, n.getDiaChi());
            ps.setString(4,  n.getNgaySinh());
            ps.setString(5, n.getDienThoai());
            ps.setString(6, n.getTrangThai());
            ps.setString(7, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean delete(String ma) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete khachhang where ma=?";
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
        System.out.println(k.getAll());
    }
}
