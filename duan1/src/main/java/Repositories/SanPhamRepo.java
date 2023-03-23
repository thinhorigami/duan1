/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.SanPhamDomain;
import java.util.List;
import viewmodel.SanPhamViewModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.DBConnection;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamRepo {

    public List<SanPhamViewModel> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[ma]\n"
                + "      ,[ten]\n"
                + "      ,[trang_thai]\n"
                + "  FROM [dbo].[SanPham]";

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamViewModel> listSp = new ArrayList<>();
            while (rs.next()) {
                listSp.add(new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
//            ResultSet rs = ps.executeQuery();
//            List<SanPhamViewModel> listSP = new ArrayList<>();
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String ma = rs.getString("ma");
//                String ten = rs.getString("ten");
//                String trangThai = rs.getString("trang_thai");
//                SanPhamViewModel sp = new SanPhamViewModel(id, ma, ten, trangThai);
//                listSP.add(sp);
//            }
//            return listSP;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        } catch (Exception ex) {
//            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;

    }

    public boolean add(SanPhamDomain sp) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([ma]\n"
                + "           ,[ten]\n"
                + "           ,[trang_thai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getTrangThai());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(SanPhamDomain sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [ma] = ?\n"
                + "      ,[ten] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + " WHERE Ma = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getTrangThai());
            ps.setObject(4, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE ma = ?";
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
