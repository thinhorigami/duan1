/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.HoaDon;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author PC
 */
public interface BanHangService {

    void getAllTenKH(List<String> kh);

    void getAllTenNV(List<String> nv);

    void getAllKhuyenMai(List<String> km);

    void getAllManv(List<String> list);

    void getAllMakh(List<String> list);

    void getAllMaHDChuaThanhToan(List<HoaDon> list);

    void getAllMaHD(List<String> hd);

    List<SanPhamCTViewModel> timTenSanPhamChiTiet(List<SanPhamCTViewModel> list, String name);

    int layGiaGiamPhanTram(int giaTien, String maKM);

    int layGiamGiaThuong(String maKM);

    int layGiaThanhTien(int tongTien, int giamGia);

    String addHD();

    String ThanhToan(String tenkh, String manv, String makm, String mahd);

    boolean layDonViKM(String maKM);

    void updateSoLuong(int soLuongMua, String idCTSP);

    String themThongTinVaoHoaDon(String tenkh, String manv, String mahd);

    void addHDCT(String idCTSP, String maHD, int soLuong);

    void deleteHDCT(String idCTSP, String mahd);

    void xoaSPDaCoTrongHD(String idSPCT, String mahd);
    
    public int layGiaTien(String mahd);
}
