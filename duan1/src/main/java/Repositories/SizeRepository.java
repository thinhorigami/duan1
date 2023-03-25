/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84961
 */
public class SizeRepository {

    public List<SizeDomain> getAll() throws SQLException {
        ArrayList<SizeDomain> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from size";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new SizeDomain(rs.getString("id"), rs.getString("ma_size"), rs.getString("so_size"), rs.getInt("trang_thai")));

        }
        return n;
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(new SizeRepository().getAll().toString());
        SizeRepository s = new SizeRepository();
        SizeDomain s1 = new SizeDomain();
        s1.setSoSize("39");
        s.delete("S1");
    }

    public SizeDomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_size]"
                + "      ,[so_size]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[Size] WHERE [Size].so_size = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SizeDomain x = new SizeDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SizeDomain ms) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO Size\n"
                    + "                  (ma_size, so_size, trang_thai)\n"
                    + "VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getSoSize());
            ps.setInt(3, ms.getTrangThai());
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean update( String id, SizeDomain ms) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE Size\n" +
"          SET          so_size =?, trang_thai =? where ma_size=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ms.getSoSize());
            ps.setInt(2, ms.getTrangThai());
            ps.setString(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }

    public boolean delete(String id) {
       try {
            Connection conn = DBContext.getConnection();
            String sql = "Delete  Size\n"
                    + "where         ma_size=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);
           
            ps.executeUpdate();
            return true;
        } catch (SQLException sQLException) {
            return false;
        }
    }
    
   
}
