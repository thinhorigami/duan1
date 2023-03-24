/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.MauSacdomain;
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
public class MauSacRepository {
    public List<MauSacdomain> getAll(){
        List<MauSacdomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_mau]"
                + "      ,[ten_mau]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[MauSac]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSacdomain mauSac = new MauSacdomain(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getInt(4));
                list.add(mauSac);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new MauSacRepository().getOne("Đen").toString());
    }
    
    
    public MauSacdomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_mau]"
                + "      ,[ten_mau]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[MauSac] WHERE [MauSac].ten_mau = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MauSacdomain mauSac = new MauSacdomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return mauSac;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(MauSacdomain ms) {
        String query = "INSERT INTO [dbo].[MauSac] "
                + "           ([ma_mau], [ten_mau]) "
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


    public boolean update(MauSacdomain ms, String id) {
        String query = "UPDATE [dbo].[MauSac] "
                + "   SET [ma_mau] = ? "
                + "      ,[ten_mau] = ? "
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
        String query = "DELETE FROM [dbo].[MauSac] "
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
