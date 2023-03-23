/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.NSXdomain;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import Utilities.DBConnection;
import viewmodel.NSXViewModel;

/**
 *
 * @author ADMIN
 */
public class NSXRepository {

    public List<NSXViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[NhaSanXuat]";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NSXViewModel> listSp = new ArrayList<>();
            while (rs.next()) {
                listSp.add(new NSXViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NSXdomain nsxd) {
        String query = "INSERT INTO [dbo].[NhaSanXuat]\n"
                + "           ([ma]\n"
                + "           ,[ten]\n"
                + "           ,[trang_thai])"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsxd.getMa());
            ps.setObject(2, nsxd.getTen());
            ps.setObject(3, nsxd.getTrangThai());

            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NSXdomain nsxd, String Ma) {
        String query = "UPDATE [dbo].[NhaSanXuat]\n"
                + "   SET [ma] = ?\n"
                + "      ,[ten] = ?\n"
                + "      ,[trang_thai] = ?,>"
                + " WHERE Ma like ? ";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsxd.getMa());
            ps.setObject(2, nsxd.getTen());
            ps.setObject(3, nsxd.getTrangThai());
            ps.setObject(4, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[NhaSanXuat]\n"
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
