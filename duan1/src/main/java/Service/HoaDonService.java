/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author 84982
 */
public interface HoaDonService {
    List<HoaDon> getAll();

    public ArrayList<String> getListTrangThai();

    public ArrayList<String> getLisNgayTao();

    public ArrayList<String> getLisNgayThanhToan();
    
    ArrayList<HoaDonViewModel> hoaDonCT(String idHoaDon);
}
