/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class ChiTietSanPhamRepository {


    public ArrayList<SanPhamCTViewModel> getAll() throws SQLException {
        ArrayList<SanPhamCTViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select ChiTietSanPham.ID 'IDSP', \n"
                + "SanPham.ten_sp 'TenSP', NhaSanXuat.ten_nsx 'TenNSX', MauSac.ten_mau 'Ten mau',\n"
                + "DongSanPham.ten_dong 'Ten dong SP', ChatLieu.ten_chat_lieu 'Ten chat lieu', size.so_size 'So size',\n"
                + "mo_ta,so_luong_ton,gia_nhap,gia_ban,anh,trangThai\n"
                + "from ChiTietSanPham join SanPham\n"
                + "on ChiTietSanPham.id_sp = SanPham.ID\n"
                + "left join NhaSanXuat on ChiTietSanPham.id_nsx = NhaSanXuat.ID \n"
                + "left join MauSac on ChiTietSanPham.id_mau_sac  = MauSac.ID\n"
                + "left join DongSanPham on DongSanPham.id = ChiTietSanPham.id_dong_sp\n"
                + " left join ChatLieu on ChatLieu.ID = ChiTietSanPham.id_chat_lieu\n"
                + "left join size on Size.ID = ChiTietSanPham.id_size\n"
                + "where  ChiTietSanPham.trangThai = 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new SanPhamCTViewModel(rs.getString("IDSP"),
                    rs.getString("TenSP"),
                    rs.getString("TenNSX"),
                    rs.getString("Ten mau"),
                    rs.getString("Ten dong SP"),
                    rs.getString("Ten chat lieu"),
                    rs.getString("So size"),
                    rs.getString("mo_ta"),
                    rs.getInt("so_luong_ton"),
                    rs.getBigDecimal("gia_nhap"),
                    rs.getBigDecimal("gia_ban"),
                    rs.getString("anh"),
                    rs.getInt("trangThai")));
            
        }
        return n;
        
    }
    
    public boolean add(SanPhamCTViewModel n) throws SQLException {
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
            ps.setString(4, n.getIdDongSanPham());
            ps.setString(5, n.getIdChatLieu());
            ps.setString(6, n.getIdSize());
            ps.setString(7, n.getMoTa());
            ps.setInt(8, n.getSoLuongTon());
            ps.setBigDecimal(9, n.getGiaNhap());
            ps.setBigDecimal(10, n.getGiaBan());
            ps.setString(11, n.getAnh());
            ps.setInt(12, n.getTrangThai());
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
        
    }
    
    public boolean update(String ma, SanPhamCTViewModel n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE ChiTietSanPham\n"
                    + "SET          id_sp =?,"
                    + " id_nsx =?,"
                    + " id_mau_sac =?, "
                    + "id_dong_sp =?,"
                    + " id_chat_lieu =?,"
                    + " id_size =?,"
                    + " mo_ta =?, "
                    + "so_luong_ton =?, "
                    + "gia_nhap =?, "
                    + "gia_ban =?,"
                    + " anh =?,"
                    + " trangThai =? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getIdSP());
            ps.setString(2, n.getIdNSX());
            ps.setString(3, n.getIdMauSac());
            ps.setString(4, n.getIdDongSanPham());
            ps.setString(5, n.getIdChatLieu());
            ps.setString(6, n.getIdSize());
            ps.setString(7, n.getMoTa());
            ps.setInt(8, n.getSoLuongTon());
            ps.setBigDecimal(9, n.getGiaNhap());
            ps.setBigDecimal(10, n.getGiaBan());
            ps.setString(11, n.getAnh());
            ps.setInt(12, n.getTrangThai());
            ps.setString(13, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }
    
    public boolean delete(String ma) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete ChiTietSanPham where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        ChiTietSanPhamRepository ct = new ChiTietSanPhamRepository();
//        System.out.println(ct.getAll());
        SanPhamCTViewModel sp = new SanPhamCTViewModel();
//        sp.setMoTa("hihi");
////        sp.setGiaBan("hh");
//ct.add(sp);
//        System.out.println(ct.add(sp));
        sp.setMoTa("hehehe");
        System.out.println(ct.update("814783AE-3A96-421D-8678-F60E647D77A7", sp));
        
    }
}
