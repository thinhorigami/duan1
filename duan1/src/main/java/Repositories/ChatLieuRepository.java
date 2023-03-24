/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChatLieuDomain;
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
public class ChatLieuRepository {
    public List<ChatLieuDomain> getAll(){
        List<ChatLieuDomain> list = new ArrayList<>();
        String query = "SELECT [ID]"
                + "      ,[ma_chat_lieu]"
                + "      ,[ten_chat_lieu]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[ChatLieu]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieuDomain cl = new ChatLieuDomain(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getInt(4));
                list.add(cl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new ChatLieuRepository().getAll().toString());
    }
    
    
    public ChatLieuDomain getOne(String name) {
        String query = "SELECT [ID]"
                + "      ,[ma_chat_lieu]"
                + "      ,[ten_chat_lieu]"
                + "      ,[trang_thai]"
                + "  FROM [dbo].[ChatLieu] WHERE [ChatLieu].ten_chat_lieu = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ChatLieuDomain chatLieu = new ChatLieuDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return chatLieu;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public boolean add(ChatLieuDomain ms) {
        String query = "INSERT INTO [dbo].[ChatLieu] "
                + "           ([ma_chat_lieu], [ten_chat_lieu]) "
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


    public boolean update(ChatLieuDomain ms, String id) {
        String query = "UPDATE [dbo].[ChatLieu] "
                + "   SET [ma_chat_lieu] = ? "
                + "      ,[ten_chat_lieu] = ? "
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
        String query = "DELETE FROM [dbo].[ChatLieu] "
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
