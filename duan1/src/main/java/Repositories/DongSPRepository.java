/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
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
public class DongSPRepository {
    public List<DongSPDomain> getAll(){
        List<DongSPDomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_dong]"
                + "      ,[ten_dong]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[DongSanPham]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSPDomain x = new DongSPDomain(rs.getString(1), rs.getString(2), rs.getString(3),
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
        System.out.println(new DongSPRepository().getAll().toString());
    }
    
    
    public DongSPDomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_dong]"
                + "      ,[ten_dong]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[DongSanPham] WHERE [DongSanPham].ten_dong = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DongSPDomain x = new DongSPDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(DongSPDomain ms) {
        String query = "INSERT INTO [dbo].[DongSanPham] "
                + "           ([ma_dong], [ten_dong]) "
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


    public boolean update(DongSPDomain ms, String id) {
        String query = "UPDATE [dbo].[DongSanPham] "
                + "   SET [ma_dong] = ? "
                + "      ,[ten_dong] = ? "
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
        String query = "DELETE FROM [dbo].[DongSanPham] "
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
