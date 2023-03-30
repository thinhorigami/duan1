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
import viewmodel.ViewModelHoaDonBanHang;
import viewmodel.ViewModelHoaDonChiTiet;

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
        String query = "SELECT \n"
                + "      [ma_khuyen_mai]\n"
                + "      \n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  where KhuyenMai.trang_thai = 1";
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
                + "  where maNV = ?";
        String a = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, a);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString("ID");
            }
            return a;
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

    public ArrayList<SanPhamCTViewModel> timKiemTheoTen(String name) throws SQLException {
        ArrayList<SanPhamCTViewModel> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select ChiTietSanPham.ID 'IDSP', \n"
                + "SanPham.ten_sp 'TenSP', NhaSanXuat.ten_nsx 'TenNSX', MauSac.ten_mau 'Ten mau',\n"
                + "DongSanPham.ten_dong 'Ten dong SP', ChatLieu.ten_chat_lieu 'Ten chat lieu', size.so_size 'So size',\n"
                + "mo_ta,so_luong_ton,gia_nhap,gia_ban,anh,trangThai\n"
                + "from ChiTietSanPham join SanPham\n"
                + "on ChiTietSanPham.id_sp = SanPham.ID\n"
                + "left join NhaSanXuat on ChiTietSanPham.id_nsx = NhaSanXuat.ID \n"
                + "left join MauSac on ChiTietSanPham.id_mau_sac  = MauSac.ID\n"
                + "left join DongSanPham on DongSanPham.id = ChiTietSanPham.id_dong_sp\n"
                + " left join ChatLieu on ChatLieu.ID = ChiTietSanPham.id_chat_lieu\n"
                + "left join size on Size.ID = ChiTietSanPham.id_size\n"
                + "where  SanPham.ten_sp like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        String a = "%" + name + "%";
        ps.setObject(1, a);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new SanPhamCTViewModel(rs.getString("IDSP"),
                    rs.getString("TenSP"),
                    rs.getString("TenNSX"),
                    rs.getString("Ten mau"),
                    rs.getString("Ten dong SP"),
                    rs.getString("Ten chat lieu"),
                    rs.getString("So size"),
                    rs.getString("mo_ta"),
                    rs.getInt("so_luong_ton"),
                    rs.getBigDecimal("gia_nhap"),
                    rs.getBigDecimal("gia_ban"),
                    rs.getString("anh"),
                    rs.getInt("trangThai")));

        }
        return n;
    }

//    public List<HoaDon> getAllHDChuaThanhToan() {
//        String query = "   select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV, \n"
//                + "          HoaDon.ngayTao, HoaDon.trang_thai,\n"
//                + "          HoaDon.ngayThanhToan, KhuyenMai.giam_gia\n"
//                + "          from HoaDon \n"
//                + "          join KhachHang on KhachHang.ID = HoaDon.idKH \n"
//                + "          join NhanVien on NhanVien.ID = HoaDon.idNV \n"
//                + "          join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
//                + "          where HoaDon.trang_thai = 0";
//        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            List<HoaDon> listHoaDon = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                NhanVien nhanVien = new NhanVien(rs.getString(3));
//                KhachHang khachHang = new KhachHang(rs.getString(2));
//                KhuyenMai khuyenMai = new KhuyenMai(rs.getInt(7));
//                HoaDon hoaDon = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4), rs.getInt(5), rs.getDate(6), khuyenMai);
//                listHoaDon.add(hoaDon);
//            }
//            return listHoaDon;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
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

    public int layGiaTien(String mahd) {
        String query = "select SUM(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban) * (KhuyenMai.giam_gia / 100) as 'thanh tien' \n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.ID = HoaDonChiTiet.id_HoaDon\n"
                + "join ChiTietSanPham on HoaDonChiTiet.id_ChiTietSP = ChiTietSanPham.ID\n"
                + "join KhuyenMai on HoaDon.id_khuyenMai = KhuyenMai.ID\n"
                + "where HoaDon.maHoaDon = ?\n"
                + "group by KhuyenMai.giam_gia";
        int a = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, mahd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int layGiaGiamPhanTram(int giaTien, String makm) {
        String query = "Select ? * (KhuyenMai.giam_gia / 100) from KhuyenMai where ma_khuyen_mai = ?";
        int a = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, giaTien);
            ps.setObject(2, makm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int layGiaGiam(String makm) {
        String query = "select giam_gia from KhuyenMai where ma_khuyen_mai = ?";
        int a = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, makm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int laythanhTien(int tongTien, int giamGia) {
        String query = "select ? - ?";
        int a = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tongTien);
            ps.setObject(2, giamGia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public boolean layDonViKM(String makm) {
        String query = "select don_vi from KhuyenMai where ma_khuyen_mai = /";
        boolean a = false;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, makm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getBoolean(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public String layIDHoaDon(String mahd) {
        String query = "SELECT [ID]\n"
                + "     \n"
                + "  FROM [dbo].[HoaDon]\n"
                + "  where maHoaDon = 'HD001'";
        String a = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, mahd);
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

    public boolean addVaoHoaDonCT(String idCTSP, String maHD, int soLuong) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([id_HoaDon]\n"
                + "           ,[id_ChiTietSP]\n"
                + "           ,[so_luong_mua])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, layIDHoaDon(maHD));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteVaoHoaDonCT(String idCTSP, String mahd) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE id_Chi_TietSP = ? and id_HoaDon = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, layIDHoaDon(mahd));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean addHoaDon() {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           (\n"
                + "           [ngayTao]\n"
                + "           ,[trang_thai]\n"
                + "           ,[maHoaDon])\n"
                + "     VALUES\n"
                + "           (GETDATE(),?,?)";
        int check = 0;
        String mahd = maHD();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, mahd);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean themThongTinVaoHD(String tenkh, String manv, String mahd) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET \n"
                + "	  [idKH] = ?\n"
                + "      ,[idNV] = ?\n"
                + " WHERE maHoaDon = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, layIDKH(tenkh));
            ps.setObject(2, layIDNV(manv));
            ps.setObject(3, mahd);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public void xoaSPDaCo(String idSPCT, String mahd) {
        String query = "DELETE HoaDonChiTiet FROM [dbo].[HoaDonChiTiet]\n"
                + "inner join HoaDon on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + "      WHERE id_ChiTietSP = ? and HoaDon.maHoaDon != ? and HoaDon.trang_thai = 0;";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idSPCT);
            ps.setObject(2, mahd);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean updateSoLuong(int soLuongMua, String idCTSP) {
        String query = "UPDATE [dbo].[ChiTietSanPham]\n"
                + "   SET \n"
                + "      [so_luong_ton] = so_luong_ton - ?\n"
                + "      \n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean ThanhToan(String tenkh, String manv, String makm, String mahd) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET\n"
                + "      [idKH] = ?\n"
                + "      ,[idNV] = ?\n"
                + "      ,[trang_thai] = ?\n"
                + "      ,[ngayThanhToan] = ?\n"
                + "      ,[id_khuyenMai] = ?\n"
                + " WHERE maHoaDon = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, layIDNV(manv));
            ps.setObject(2, layIDKH(tenkh));
            ps.setObject(3, makm);
            ps.setObject(4, mahd);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public String layTenSP(String idSP) {
        String query = "select SanPham.ten_sp from SanPham \n"
                + "join ChiTietSanPham on SanPham.ID = ChiTietSanPham.id_sp\n"
                + " where ChiTietSanPham.ID = ?";
        String a = "";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getString(1);
            }
            return a;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    public int layGiaTien(String maHD) {
//        String query = "Select SUM(gia_ban) from QuocGiaDong\n"
//                + "join ChiTietDienThoai on QuocGiaDong.id=ChiTietDienThoai.id_quoc_gia_dong\n"
//                + "join HoaDonChiTiet on ChiTietDienThoai.IMEI=HoaDonChiTiet.IMEI\n"
//                + "join HoaDon on HoaDon.id=HoaDonChiTiet.id_hoa_don\n"
//                + "where ma_hoa_don = ?";
//        int a = 0;
//        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1, maHD);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                a = rs.getInt(1);
//            }
//            return a;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        }
//        return 0;
//    }
    public ArrayList<ViewModelHoaDonChiTiet> getAll(String mahd) throws SQLException {
        ArrayList<ViewModelHoaDonChiTiet> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select ChiTietSanPham.ID 'IDSP', \n"
                + "                SanPham.ten_sp 'TenSP', NhaSanXuat.ten_nsx 'TenNSX', MauSac.ten_mau 'Ten mau',\n"
                + "                DongSanPham.ten_dong 'Ten dong SP', ChatLieu.ten_chat_lieu 'Ten chat lieu', size.so_size 'So size',\n"
                + "                mo_ta,so_luong_mua,gia_ban,trangThai\n"
                + "                from ChiTietSanPham join SanPham\n"
                + "                on ChiTietSanPham.id_sp = SanPham.ID\n"
                + "                left join NhaSanXuat on ChiTietSanPham.id_nsx = NhaSanXuat.ID \n"
                + "                left join MauSac on ChiTietSanPham.id_mau_sac  = MauSac.ID\n"
                + "                left join DongSanPham on DongSanPham.id = ChiTietSanPham.id_dong_sp\n"
                + "                 left join ChatLieu on ChatLieu.ID = ChiTietSanPham.id_chat_lieu\n"
                + "                left join size on Size.ID = ChiTietSanPham.id_size\n"
                + "		left join HoaDonChiTiet on ChiTietSanPham.ID = HoaDonChiTiet.id_ChiTietSP\n"
                + "		join HoaDon on HoaDonChiTiet.id_HoaDon = HoaDon.ID\n"
                + "                where maHoaDon = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, mahd);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new ViewModelHoaDonChiTiet(rs.getString("IDSP"), rs.getString("TenSP"),
                    rs.getString("TenNSX"), rs.getString("Ten mau"), rs.getString("Ten dong SP"), rs.getString("Ten chat lieu"),
                    rs.getInt("So size"), rs.getString("mo_ta"), rs.getInt("so_luong_mua"), rs.getDouble("gia_ban"), rs.getInt("trangThai")));
        }
        return n;
    }

    public List<ViewModelHoaDonBanHang> getAllHoaDon() {
        String query = "select HoaDon.maHoaDon, KhachHang.tenKH, NhanVien.tenNV,\n"
                + "     HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan, IIF(KhuyenMai.giam_gia > 1000, SUM(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban) - KhuyenMai.giam_gia,\n"
                + "      SUM(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban) - (SUM(HoaDonChiTiet.so_luong_mua * ChiTietSanPham.gia_ban) * (KhuyenMai.giam_gia / 100))) as 'thanh tien', KhuyenMai.ma_khuyen_mai,\n"
                + "      IIF(KhuyenMai.giam_gia > 100, KhuyenMai.giam_gia,sum(ChiTietSanPham.gia_ban * HoaDonChiTiet.so_luong_mua) * (KhuyenMai.giam_gia / 100)) as 'gia giam'\n"
                + "	from HoaDon join KhachHang on KhachHang.ID = HoaDon.idKH\n"
                + "      left join NhanVien on NhanVien.ID = HoaDon.idNV\n"
                + "       left join KhuyenMai on KhuyenMai.ID = HoaDon.id_khuyenMai\n"
                + "        left join HoaDonChiTiet on HoaDon.ID = HoaDonChiTiet.id_HoaDon\n"
                + "		left join ChiTietSanPham on HoaDonChiTiet.id_ChiTietSP = ChiTietSanPham.ID\n"
                + "         where HoaDon.trang_thai = 0\n"
                + "        group by HoaDon.maHoaDon,KhachHang.tenKH, NhanVien.tenNV,\n"
                + "         HoaDon.ngayTao, HoaDon.trang_thai, HoaDon.ngayThanhToan,KhuyenMai.giam_gia ,\n"
                + "           HoaDonChiTiet.so_luong_mua,KhuyenMai.ma_khuyen_mai";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ViewModelHoaDonBanHang> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewModelHoaDonBanHang bh = new ViewModelHoaDonBanHang(
                        rs.getString("maHoaDon"),
                        rs.getString("tenKH"), rs.getString("tenNV"),
                        rs.getDate("ngayTao"), rs.getInt("trang_thai"),
                        rs.getDate("ngayThanhToan"), rs.getDouble("thanh tien"),
                        rs.getString("ma_khuyen_mai"),
                        rs.getDouble("gia giam"));
                listHoaDon.add(bh);
            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {

        BanHangRepository bh = new BanHangRepository();
//        System.out.println(bh.getAllKH());
//        System.out.println(bh.getAllManv());
//        System.out.println(bh.getAllNV());
//        System.out.println(bh.getAllManv());
//        System.out.println(bh.getAllMaKH());
//        System.out.println(bh.timKiemTheoTen("Giày"));
//        System.out.println(bh.getAllHDChuaThanhToan());
////System.out.println(bh.layTenSP("1412CD61-49F8-4C98-9924-1D47855EEE28"));
//        System.out.println(bh.getAll("HD003"));
        System.out.println(bh.getAllHoaDon());

    }
}
