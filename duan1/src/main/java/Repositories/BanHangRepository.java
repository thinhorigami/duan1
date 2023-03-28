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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodel.SanPhamCTViewModel;
import viewmodel.ViewModelBanHang;

public class BanHangRepository {

    public List<String> getAllTenKH() {
        String query = "SELECT \n"
                + "      [tenKH]\n"
                + "  FROM [dbo].[KhachHang]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKH"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllTenNV() {
        String query = "SELECT \n"
                + "      [tenNV]\n"
                + "     \n"
                + "  FROM [dbo].[NhanVien]";

        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenNv"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllMAKM() {
        String query = "SELECT[ma_khuyen_mai]\n"
                + "      \n"
                + "  FROM [dbo].[KhuyenMai]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("ma_khuyen_mai"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllManv() {
        String query = "SELECT [maNV]\n"
                + "  FROM [dbo].[NhanVien]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maNV"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllMaKH() {
        String query = "SELECT [maKH]\n"
                + "      \n"
                + "  FROM [dbo].[KhachHang]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maKH"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String layIDKH(String tenKh) {
        String query = "SELECT [ID]\n"
                + "     \n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  where tenKH = ?";
        String a = "N" + tenKh;
        String b = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(tenKh);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getString("ID");
            }
            return b;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String layIDNV(String tenNV) {
        String query = "SELECT [ID]\n"
                + "      \n"
                + "  FROM [dbo].[NhanVien]\n"
                + "  where tenNV = ?";
        String a = "N" + tenNV;
        String b = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getString("ID");
            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String layIDKM(String maKM) {
        String query = "SELECT [ID]\n"
                + "     \n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  where ma_khuyen_mai = ? ";
        String a = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("ID");
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ViewModelBanHang> timKiemTheoTen(String name) {
        String query = "select ChiTietSanPham.ID,\n"
                + "                SanPham.ten_sp, NhaSanXuat.ten_nsx , MauSac.ten_mau ,\n"
                + "                DongSanPham.ten_dong , ChatLieu.ten_chat_lieu , size.so_size ,\n"
                + "                mo_ta,so_luong_ton,gia_nhap,gia_ban,trangThai\n"
                + "                from ChiTietSanPham join SanPham\n"
                + "                on ChiTietSanPham.id_sp = SanPham.ID\n"
                + "                 join NhaSanXuat on ChiTietSanPham.id_nsx = NhaSanXuat.ID \n"
                + "                 join MauSac on ChiTietSanPham.id_mau_sac  = MauSac.ID\n"
                + "                 join DongSanPham on DongSanPham.id = ChiTietSanPham.id_dong_sp\n"
                + "                 join ChatLieu on ChatLieu.ID = ChiTietSanPham.id_chat_lieu\n"
                + "                 join size on Size.ID = ChiTietSanPham.id_size \n"
                + "				 where ten_sp like ?";
        List<ViewModelBanHang> list = new ArrayList<>();
        String a = "%" + name + "%";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelBanHang view = new ViewModelBanHang(rs.getString("ID"), rs.getString("ten_sp"),
                        rs.getString("ten_nsx"), rs.getString("ten_mau"), rs.getString("ten_dong"),
                        rs.getString("ten_chat_lieu"), rs.getInt("so_size"), rs.getString("mo_ta"),
                        rs.getInt("so_luong_ton"), rs.getDouble("gia_nhap"), rs.getDouble("gia_ban"), rs.getInt("trangThai"));
                list.add(view);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> getAllHDChuaThanhToan() {
        String query = "   select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, \n"
                + "          HoaDon.ngayTao, HoaDon.trang_thai,\n"
                + "          HoaDon.ngayThanhToan, KhuyenMai.giam_gia\n"
                + "          from HoaDon \n"
                + "          join KhachHang on KhachHang.ID = HoaDon.idKH \n"
                + "          join NhanVien on NhanVien.ID = HoaDon.idNV \n"
                + "          join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + "          where HoaDon.trang_thai = 0";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3));
                KhachHang khachHang = new KhachHang(rs.getString(2));
                KhuyenMai khuyenMai = new KhuyenMai(rs.getInt(7));
                HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<String> getAllMaHD() {
        String query = "SELECT\n"
                + "      [maHoaDon]\n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where trang_thai = 0";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maHoaDon"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String maHD() {
        HoaDon hd = new HoaDon();
        List<String> hdl = getAllMaHD();
        List<Integer> hds = new ArrayList<>();
        for (String hoaDon : hdl) {
            int soHD = Integer.valueOf(hoaDon.substring(2)) + 1;
            hds.add(soHD);
        }
        int j = 0;
        for (Integer integer : hds) {
            int i = integer;
            if (j < i) {
                j = i;
            }
        }
        return "HD" + j;
    }

    public static void main(String[] args) {

        BanHangRepository bh = new BanHangRepository();
//        System.out.println(bh.getAllKH());
//        System.out.println(bh.getAllManv());
//        System.out.println(bh.getAllNV());
//        System.out.println(bh.getAllManv());
//        System.out.println(bh.getAllMaKH());
    }
}
