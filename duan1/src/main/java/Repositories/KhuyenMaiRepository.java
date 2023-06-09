package Repositories;

import viewmodel.KhuyenMaiViewmodel;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhuyenMaiRepository {

    public ArrayList<KhuyenMaiViewmodel> getAll() throws SQLException {
        ArrayList<KhuyenMaiViewmodel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from KhuyenMai where trang_thai = 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new KhuyenMaiViewmodel(rs.getString("id"),
                    rs.getString("ma_khuyen_mai"),
                    rs.getString("ten_khuyen_mai"),
                    rs.getString("ngay_bat_dau"),
                    rs.getString("ngay_ket_thuc"),
                    rs.getInt("giam_gia"),
                    rs.getBoolean("don_vi"),
                    rs.getString("mo_ta"),
                    rs.getInt("trang_thai")));

        }
        return n;

    }

    public boolean add(KhuyenMaiViewmodel n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = """
                         INSERT INTO KhuyenMai
                                   (ma_khuyen_mai, ten_khuyen_mai, ngay_bat_dau, ngay_ket_thuc, giam_gia, don_vi,mo_ta, trang_thai)
                         VALUES (?,?,?,?,?,?,?,?)""";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMa());
            ps.setString(2, n.getTenKM());
            ps.setString(3, n.getNgayBatDau());
            ps.setString(4, n.getNgayKetThuc());
            ps.setInt(5, n.getMuc_giam_gia());
            ps.setBoolean(6, n.getDonVi());
            ps.setString(7, n.getMoTa());
            ps.setInt(8, n.getTrangThai());

            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }

    }

    public boolean update(String ma, KhuyenMaiViewmodel n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE KhuyenMai SET ten_khuyen_mai =?, giam_gia =?, ngay_bat_dau =?, ngay_ket_thuc =?, don_vi =?,mo_ta =?, trang_thai =? where ma_khuyen_mai=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getTenKM());
            ps.setInt(2, n.getMuc_giam_gia());
            ps.setString(3, n.getNgayBatDau());
            ps.setString(4, n.getNgayKetThuc());
            ps.setBoolean(5, n.getDonVi());
            ps.setString(6, n.getMoTa());
            ps.setInt(7, n.getTrangThai());
            ps.setString(8, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean delete(String ma) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "delete KhuyenMai where ma_khuyen_mai=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public ArrayList<KhuyenMaiViewmodel> timKiemTheoTen(String ten) throws SQLException {
        ArrayList<KhuyenMaiViewmodel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from KhuyenMai where ten_khuyen_mai LIKE '%" + ten + "%' ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new KhuyenMaiViewmodel(rs.getString("id"),
                    rs.getString("ma_khuyen_mai"),
                    rs.getString("ten_khuyen_mai"),
                    rs.getString("ngay_bat_dau"),
                    rs.getString("ngay_ket_thuc"),
                    rs.getInt("giam_gia"),
                    rs.getBoolean("don_vi"),
                    rs.getString("mo_ta"),
                    rs.getInt("trang_thai")));

        }
        return n;
    }
    
    public ArrayList<KhuyenMaiViewmodel> locTheoTrangThai(int trangThai) throws SQLException {
        ArrayList<KhuyenMaiViewmodel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from KhuyenMai where trang_thai LIKE '%" + trangThai + "%'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new KhuyenMaiViewmodel(rs.getString("id"),
                    rs.getString("ma_khuyen_mai"),
                    rs.getString("ten_khuyen_mai"),
                    rs.getString("ngay_bat_dau"),
                    rs.getString("ngay_ket_thuc"),
                    rs.getInt("giam_gia"),
                    rs.getBoolean("don_vi"),
                    rs.getString("mo_ta"),
                    rs.getInt("trang_thai")));

        }
        return n;
        
    }
    
    public boolean voHieuHoa(String ma, KhuyenMaiViewmodel n) throws SQLException {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE KhuyenMai SET trang_thai = 0 where ma_khuyen_mai=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }
    

}
