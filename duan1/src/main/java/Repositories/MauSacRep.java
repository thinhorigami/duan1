/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.MauSacdomain;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import Utilities.DBConnection;
import viewmodel.MauSacViewModel;

/**
 *
 * @author ADMIN
 */
public class MauSacRep {

    public List<MauSacViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[MauSac]";
        List<MauSacViewModel> lists = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSacViewModel svmd = new MauSacViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lists.add(svmd);

            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(MauSacdomain msvmd) {
        String query = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([ma]\n"
                + "           ,[ten]\n"
                + "           ,[trang_thai])"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, msvmd.getMa());
            ps.setObject(2, msvmd.getTen());
            ps.setObject(3, msvmd.getTrangThai());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(MauSacdomain msvmd, String Ma) {
        String query = "UPDATE [dbo].[MauSac]\n"
                + "   SET [ma] = ?\n"
                + "      ,[ten] = ?\n"
                + "      ,[trang_thai] = ?,>"
                + " WHERE Ma like ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, msvmd.getTen());
            ps.setObject(2, msvmd.getTrangThai());
            ps.setObject(3, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[MauSac]\n"
                + "WHERE Ma=?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }
}
