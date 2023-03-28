/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.HoaDon;
import Repositories.HoaDonRepository;
import Service.HoaDonService;
import java.util.ArrayList;
import java.util.List;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author 84982
 */
public class HoaDonServiceImpl implements  HoaDonService{
private HoaDonRepository repository = new HoaDonRepository();
    @Override
    public List<HoaDon> getAll() {
          return repository.getAll();
    }

    

    @Override
    public ArrayList<String> getLisNgayTao() {
        return repository.getLisNgayTao();
    }

    @Override
    public ArrayList<String> getLisNgayThanhToan() {
        return repository.getLisNgayThanhToan();
    }

    @Override
    public ArrayList<HoaDonViewModel> hoaDonCT(String idHoaDon) {
        try {
            return repository.hoaDonCT(idHoaDon);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDon> search(String ma) {
        return repository.search(ma);
    }

    @Override
    public List<HoaDon> searchTT(int trangThai) {
                return repository.searchTT(trangThai);

    }

    @Override
    public List<HoaDon> searchNgayTao(String ngayTao) {
                return repository.searchNgayTao(ngayTao);

    }

    @Override
    public List<HoaDon> searchNgayThanhToan(String ngayTT) {
                return repository.searchNgayThanhToan(ngayTT);

    }
    
}
