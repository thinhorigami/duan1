/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.SanPhamDomain;
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
public class SanPhamRepositor {
    public List<SanPhamDomain> getAll(){
        List<SanPhamDomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_sp]"
                + "      ,[ten_sp]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamDomain x = new SanPhamDomain(rs.getString(1), rs.getString(2), rs.getString(3),
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
        System.out.println(new SanPhamRepositor().getAll().toString());
    }
    
    
    public SanPhamDomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_sp]"
                + "      ,[ten_sp]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[SanPham] WHERE [SanPham].ten_sp = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SanPhamDomain x = new SanPhamDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(SanPhamDomain ms) {
        String query = "INSERT INTO [dbo].[SanPham] "
                + "           ([ma_sp], [ten_sp]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMaSP());
            ps.setObject(2, ms.getTenSP());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean update(SanPhamDomain ms, String id) {
        String query = "UPDATE [dbo].[SanPham] "
                + "   SET [ma_sp] = ? "
                + "      ,[ten_sp] = ? "
                + " WHERE [ID] = ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMaSP());
            ps.setObject(2, ms.getTenSP());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }


    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[SanPham] "
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
