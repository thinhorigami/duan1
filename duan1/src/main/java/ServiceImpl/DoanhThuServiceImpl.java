/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Repositories.DoanhThuRepository;
import Service.DoanhThuService;
import java.util.ArrayList;
import javax.swing.JPanel;
import viewmodel.DoanhThuViewModel;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class DoanhThuServiceImpl implements DoanhThuService {

    private DoanhThuRepository doanhThuRepository = new DoanhThuRepository();

    @Override
    public ArrayList<DoanhThuViewModel> DTNamHienTai() {
        try {
            return doanhThuRepository.DTNamHienTai();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<DoanhThuViewModel> theoNam(String nam) {
        try {
            return doanhThuRepository.theoNam(nam);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<DoanhThuViewModel> theoTungNgayTrongThang(String nam, String thang) {
        try {
            return doanhThuRepository.theoTungNgayTrongThang(nam, thang);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int soHoaDonTrongNgay() {
        try {
           return doanhThuRepository.soHoaDonTrongNgay();
             
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int soLuongSPTrongNgay() {
        try {
            return doanhThuRepository.soLuongSPTrongNgay();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int tongDoanhThuNgay() {
        try {
            return doanhThuRepository.tongDoanhThuNgay();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean bieuDoTheoNamHienTai(JPanel jp) {
        try {
            
            doanhThuRepository.bieuDoTheoNamHienTai(jp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean bieuDoTheoNam(JPanel jp, String nam) {
        try {
            doanhThuRepository.bieuDoTheoNam(jp, nam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<DoanhThuViewModel> tuNgayDenNgay(String ngay1, String ngay2) {
        try {
            return doanhThuRepository.tuNgayDenNgay(ngay1, ngay2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean thongKeHoaDon(JPanel jp) {
        try {
             doanhThuRepository.thongKeHoaDon(jp);
             return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<DoanhThuViewModel> layNam() {
        try {
            return doanhThuRepository.layNam();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean thongKeHoaDonTheoNam(JPanel jp, String nam) {
        try {
            doanhThuRepository.thongKeHoaDonTheoNam(jp, nam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<SanPhamCTViewModel> soLuongSPSapHetHang() {
        try {
            
         return   doanhThuRepository.soLuongSPSapHetHang();
                    
        } catch (Exception e) {
            return null;
        }
    }

}
