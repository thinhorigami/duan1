/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.HoaDon;
import Repositories.BanHangRepository;
import Repositories.ChiTietSanPhamRepository;
import Service.BanHangService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author PC
 */
public class BanHangServiceImpl implements BanHangService {

    BanHangRepository bhr = new BanHangRepository();

    @Override
    public void getAllTenKH(List<String> kh) {
        kh.addAll(bhr.getAllTenKH());
    }

    @Override
    public void getAllTenNV(List<String> nv) {
        nv.addAll(bhr.getAllTenNV());
    }

    @Override
    public void getAllKhuyenMai(List<String> km) {
        km.addAll(bhr.getAllMAKM());
    }

    @Override
    public void getAllManv(List<String> list) {
        list.addAll(bhr.getAllManv());
    }

    @Override
    public void getAllMakh(List<String> list) {
        list.addAll(bhr.getAllMaKH());
    }

    @Override
    public void getAllMaHDChuaThanhToan(List<HoaDon> list) {
        list.addAll(bhr.getAllHDChuaThanhToan());
    }

    @Override
    public void getAllMaHD(List<String> hd) {
        hd.addAll(bhr.getAllMaHD());
    }

    @Override
    public List<SanPhamCTViewModel> timTenSanPhamChiTiet(List<SanPhamCTViewModel> list, String name) {
        List<SanPhamCTViewModel> listSearch = new ArrayList<>();
        try {
            list = new BanHangRepository().timKiemTheoTen(name);

            for (SanPhamCTViewModel sanPhamCTViewModel : list) {

                if (sanPhamCTViewModel.getIdSP().contains(name) || sanPhamCTViewModel.getIdNSX().contains(name) || sanPhamCTViewModel.getIdChatLieu().contains(name) ) {

                    listSearch.add(sanPhamCTViewModel);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSearch;
    }

    @Override
    public int layGiaGiamPhanTram(int giaTien, String maKM) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int layGiamGiaThuong(String maKM) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int layGiaThanhTien(int tongTien, int giamGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addHD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String ThanhToan(String tenkh, String manv, String makm, String mahd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean layDonViKM(String maKM) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateSoLuong(int soLuongMua, String idCTSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String themThongTinVaoHoaDon(String tenkh, String manv, String mahd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addHDCT(String idCTSP, String maHD, int soLuong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteHDCT(String idCTSP, String mahd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xoaSPDaCoTrongHD(String idSPCT, String mahd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int layGiaTien(String mahd) {
        return bhr.layGiaTien(mahd);
    }

}
