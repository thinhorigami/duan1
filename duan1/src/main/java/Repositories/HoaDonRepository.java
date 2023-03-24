/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.HoaDon;
import Domainmodel.KhachHang;
import Domainmodel.KhuyenMai;
import Domainmodel.NhanVien;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84982
 */
public class HoaDonRepository {

    public List<HoaDon> getAll(){
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, KhuyenMai.giam_gia\n" +
"from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH join NhanVien on NhanVien.ID = HoaDon.idNV join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               NhanVien nhanVien =new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai =new KhuyenMai(rs.getInt(7));
                HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5),rs.getDate(6),khuyenMai);
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
      public ArrayList<String> getListTrangThai() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoadon.trang_thai from hoadon ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String str = rs.getString(1);
                list.add(str);
            }
        } catch (Exception e) {
        }
        return list;
    }
      
       public ArrayList<String> getLisNgayTao() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoadon.ngayTao from HoaDon";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String str = rs.getString(1);
                list.add(str);
            }
        } catch (Exception e) {
        }
        return list;
    }
       
       public ArrayList<String> getLisNgayThanhToan() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select hoadon.ngayThanhToan from HoaDon";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String str = rs.getString(1);
                list.add(str);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
