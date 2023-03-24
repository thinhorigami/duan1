/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.NhanVienn;
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
public class NhanVienRepositoryy {

    public ArrayList<NhanVienn> getAll() throws SQLException {
        ArrayList<NhanVienn> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select NhanVien.ID 'IDNV', maNV,tenNV,gioiTinh,diaChi,matKhau,dienThoai,email,NhanVien.trangThai 'TTNV', ngaySinh, chucvu.tenChucVu 'TenCV'\n"
                + "from nhanvien join ChucVu on NhanVien.id_Chuc_Vu = ChucVu.ID\n"
                + "where NhanVien.trangThai = 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new NhanVienn(rs.getString("IDNV"),
                    rs.getString("maNV"),
                    rs.getString("tenNV"),
                    rs.getString("gioiTinh"),
                    rs.getString("diaChi"),
                    rs.getString("matKhau"),
                    rs.getString("dienThoai"),
                    rs.getString("email"),
                    rs.getInt("TTNV"),
                    rs.getString("ngaySinh"),
                    rs.getString("TenCV")));

        }
        return n;

    }

    public boolean add(NhanVienn n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO NhanVien\n"
                    + "                  (maNV, tenNV,"
                    + " gioiTinh, diaChi, matKhau,"
                    + " dienThoai, email, trangThai, ngaySinh, id_Chuc_Vu)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMaNV());
            ps.setString(2, n.getTenNV());
            ps.setString(3, n.getGioiTinh());
            ps.setString(4, n.getDiaChi());
            ps.setString(5, n.getMatKhau());
            ps.setString(6, n.getDienThoai());
            ps.setString(7, n.getEmail());
            ps.setInt(8, n.getTrangThai());
            ps.setString(9, n.getNgaySinh());
            ps.setString(10, n.getIdChucVu());
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }

    }

    public boolean update(String ma, NhanVienn n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE NhanVien\n"
                    + "SET          tenNV =?, gioiTinh =?, diaChi =?, matKhau =?,"
                    + " dienThoai =?, email =?, trangThai =?, ngaySinh =?, id_Chuc_Vu =? where maNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getTenNV());
            ps.setString(2, n.getGioiTinh());
            ps.setString(3, n.getDiaChi());
            ps.setString(4, n.getMatKhau());
            ps.setString(5, n.getDienThoai());
            ps.setString(6, n.getEmail());
            ps.setInt(7, n.getTrangThai());
            ps.setString(8, n.getNgaySinh());
            ps.setString(9, n.getIdChucVu());
            ps.setString(10, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean delete(String ma) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete nhanvien where maNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        NhanVienRepositoryy nv = new NhanVienRepositoryy();
        NhanVienn n = new NhanVienn();
        n.setTenNV("pppppp");
        nv.update("hhh", n);
    }
}
