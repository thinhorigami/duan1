/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.NSXdomain;
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
public class NsxRepository {
    public List<NSXdomain> getAll(){
        List<NSXdomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_nsx]"
                + "      ,[ten_nsx]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[NhaSanXuat]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSXdomain x = new NSXdomain(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getInt(4));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
 
    
    
    public NSXdomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_nsx]"
                + "      ,[ten_nsx]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[NhaSanXuat] WHERE [NhaSanXuat].ten_nsx = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NSXdomain x = new NSXdomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NSXdomain ms) {
        String query = "INSERT INTO [dbo].[NhaSanXuat] "
                + "           ([ma_nsx], [ten_nsx]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean update(NSXdomain ms, String id) {
        String query = "UPDATE [dbo].[NhaSanXuat] "
                + "   SET [ma_nsx] = ? "
                + "      ,[ten_nsx] = ? "
                + " WHERE [ID] = ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[NhaSanXuat] "
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
