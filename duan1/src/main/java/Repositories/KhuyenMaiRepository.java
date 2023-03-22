/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import Domainmodel.KhuyenMai;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> layDSKM() throws SQLException {
        List<KhuyenMai> khuyenMais = new ArrayList<>();
        Connection conn = DBContext.openDbConnection();
        String sql = "Select * from KhuyenMai";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt(1);
            String Ma = rs.getString(2);
            String Ten = rs.getString(3);
            String NgayBatDau = rs.getString(4);
            String NgayKetThuc = rs.getString(5);
            Integer GiamGia = rs.getInt(6);
            Boolean DonVi = rs.getBoolean(7);
            String MoTa = rs.getString(8);
            String TrangThai = rs.getString(9);

            KhuyenMai khuyenMai = new KhuyenMai(id, Ma, Ten, NgayBatDau, NgayKetThuc, GiamGia, DonVi, MoTa, TrangThai);
            khuyenMais.add(khuyenMai);
        }
        return khuyenMais;
    }

    public boolean ThemKhuyenMai(KhuyenMai khuyenMai) throws SQLException {
        int index = 0;
        try {
            Connection connection = DBContext.openDbConnection();
            String sql = "Insert into KhuyenMai (ma,ten,ngay_bat_dau,ngay_ket_thuc,giam_gia,don_vi,mo_ta,TrangThai) values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, khuyenMai.getMa());
            statement.setString(2, khuyenMai.getTenKM());
            statement.setString(3, khuyenMai.getNgayBatDau());
            statement.setString(4, khuyenMai.getNgayKetThuc());
            statement.setInt(5, khuyenMai.getMuc_giam_gia());
            statement.setBoolean(6, khuyenMai.getDonVi());
            statement.setString(7, khuyenMai.getMoTa());
            statement.setString(9, khuyenMai.getTrangThai());

            index = statement.executeUpdate();

        } catch (Exception e) {
        }
        if (index == 0) {
            return false;
        } else {
            return true;
        }
        
    }

    public boolean XoaKhuyenMai(Integer id) throws SQLException {
        Connection connection = DBContext.openDbConnection();
        String sql = "Delete form KhuyenMai where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        int index = statement.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean SuaKhuyenMai(KhuyenMai khuyenMai) throws SQLException {
        Connection connection = DBContext.openDbConnection();
String sql = "Update KhuyenMai set ma = ?,ten = ?,ngay_bat_dau = ?,ngay_ket_thuc = ?,giam_gia = ?,don_vi = ?,mo_ta = ?,TrangThai = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, khuyenMai.getMa());
        statement.setString(2, khuyenMai.getTenKM());
        statement.setString(3, khuyenMai.getNgayBatDau());
        statement.setString(4, khuyenMai.getNgayKetThuc());
        statement.setInt(5, khuyenMai.getMuc_giam_gia());
        statement.setBoolean(6, khuyenMai.getDonVi());
        statement.setString(7, khuyenMai.getMoTa());
        statement.setString(8, khuyenMai.getTrangThai());
        
        statement.setInt(9, khuyenMai.getId());

        int index = statement.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }

    }
}