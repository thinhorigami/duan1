/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DBConnection;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SizeRepo {

    public List<SizeViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[Size]";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SizeViewModel> listSz = new ArrayList<>();
            while (rs.next()) {
                listSz.add(new SizeViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listSz;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SizeDomain sz) {
        String query = "INSERT INTO [dbo].[Size]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sz.getMa());
            ps.setObject(2, sz.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(SizeDomain sp, String ma) {
        String query = "UPDATE [dbo].[Size]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[Ten] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Size]\n"
                + "      WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }
}
