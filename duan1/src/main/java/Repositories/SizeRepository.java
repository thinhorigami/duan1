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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84961
 */
public class SizeRepository {
    public List<SizeDomain> getAll(){
        List<SizeDomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_size]"
                + "      ,[so_size]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[Size]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SizeDomain x = new SizeDomain(rs.getString(1), rs.getString(2), rs.getInt(3),
                rs.getInt(4));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new SizeRepository().getAll().toString());
    }
    
    
    public SizeDomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_size]"
                + "      ,[so_size]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[Size] WHERE [Size].so_size = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SizeDomain x = new SizeDomain(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(SizeDomain ms) {
        String query = "INSERT INTO [dbo].[Size] "
                + "           ([ma_size], [so_size]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getSoSize());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean update(SizeDomain ms, String id) {
        String query = "UPDATE [dbo].[Size] "
                + "   SET [ma_size] = ? "
                + "      ,[so_size] = ? "
                + " WHERE [ID] = ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getSoSize());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[Size] "
                + "      WHERE ID = ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
