/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Utilities.DBConnection;
import viewmodel.ChatLieuViewModel;

/**
 *
 * @author Asus
 */
public class ChatLieuRepository {

    public List<ChatLieuViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[ChatLieu]";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ChatLieuViewModel> listSp = new ArrayList<>();
            while (rs.next()) {
                listSp.add(new ChatLieuViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//
//    public ChatlieuViewModel getOne(String maSV) {
//        String query = "SELECT [Id]\n"
//                + "      ,[Ma]\n"
//                + "      ,[TenCL]\n"
//                + "      ,[DacTinh]\n"
//                + "      ,[QuyTrinhSX]\n"
//                + "  FROM [dbo].[ChatLieu]"
//                + "WHERE Ma = ?";
//
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1, maSV);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return new ChatlieuViewModel(rs.getString(1),
//                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    public boolean add(ChatLieuDomain chatLieu) {
        String query = "INSERT INTO [dbo].[ChatLieu]\n"
                + "           ([ma]\n"
                + "           ,[ten]\n"
                + "           ,[trang_thai])"
                + "     VALUES (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getTrangThai());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChatLieuDomain chatLieu, String Ma) {
        String query = "UPDATE [dbo].[ChatLieu]\n"
                + "   SET [ma] = ?\n"
                + "      ,[ten] = ?\n"
                + "      ,[trang_thai] = ?,>"
                + " WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getTrangThai());
            ps.setObject(4, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[ChatLieu]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    
}
