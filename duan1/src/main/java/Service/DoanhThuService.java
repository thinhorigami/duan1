/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import javax.swing.JPanel;
import viewmodel.DoanhThuViewModel;

/**
 *
 * @author Phuong Bi
 */
public interface DoanhThuService {

    ArrayList<DoanhThuViewModel> DTNamHienTai();

    ArrayList<DoanhThuViewModel> theoNam(String nam);

    ArrayList<DoanhThuViewModel> theoTungNgayTrongThang(String nam, String thang);

    int soHoaDonTrongNgay();

    int soLuongSPTrongNgay();

    int tongDoanhThuNgay();

    boolean bieuDoTheoNamHienTai(JPanel jp);

    boolean bieuDoTheoNam(JPanel jp, String nam);

}
