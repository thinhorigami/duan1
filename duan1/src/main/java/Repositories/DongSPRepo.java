/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.DongSPDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Utilities.DBConnection;
import viewmodel.DongSPViewModel;

/**
 *
 * @author admin
 */
public class DongSPRepo {

    public List<DongSPViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[DongSanPham]";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<DongSPViewModel> listncc = new ArrayList<>();
            while (rs.next()) {
//                DongSPViewModel lsp = new DongSPViewModel(
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3));
//                listncc.add(lsp);
                DongSPViewModel lsp = new DongSPViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listncc.add(lsp);
            }
            return listncc;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(DongSPDomain lspvmd) {
        String query = "INSERT INTO [dbo].[DongSanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lspvmd.getMa());
            ps.setObject(2, lspvmd.getTen());
            ps.setObject(3, lspvmd.getTrangThai());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[DongSanPham]\n"
                + "      WHERE ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(DongSPDomain lspvmd, String Ma) {
        String query = "UPDATE [dbo].[DongSanPham]\n"
                + "   SET [Ma] =?\n"
                + "      ,[Ten] =?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE Ma like ? ";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lspvmd.getMa());
            ps.setObject(2, lspvmd.getTen());
            ps.setObject(3, lspvmd.getTrangThai());
            ps.setObject(4, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
