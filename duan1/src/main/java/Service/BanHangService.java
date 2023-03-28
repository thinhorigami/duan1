/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.HoaDon;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import viewmodel.ViewModelBanHang;

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
}
