/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChiTiet;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class ChiTietRepo {
       public boolean add(ChiTiet n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO ChiTietSanPham\n"
                    + "                  (id_sp, id_nsx, "
                    + "id_mau_sac,"
                    + " id_dong_sp, id_chat_lieu, id_size, mo_ta,"
                    + " so_luong_ton, gia_nhap, gia_ban, anh, "
                    + "trangThai)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getIdSP());
            ps.setString(2, n.getIdNSX());
            ps.setString(3, n.getIdMauSac());
            ps.setString(4, n.getDongSP());
            ps.setString(5, n.getChatLieu());
            ps.setString(6, n.getSize());
            ps.setString(7, n.getMoTa());
            ps.setString(8, n.getSoLuongTon());
            ps.setString(9, n.getGiaNhap());
            ps.setString(10, n.getGiaBan());
            ps.setString(11, n.getAnh());
            ps.setString(12, n.getTrangThai());
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
        
    }
}
