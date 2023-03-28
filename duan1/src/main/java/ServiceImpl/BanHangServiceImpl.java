/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.HoaDon;
import Repositories.BanHangRepository;
import Service.BanHangService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import viewmodel.ViewModelBanHang;

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

}
