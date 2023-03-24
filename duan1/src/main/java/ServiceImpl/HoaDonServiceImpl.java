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
    public ArrayList<String> getListTrangThai() {
          return repository.getListTrangThai();
    }

    @Override
    public ArrayList<String> getLisNgayTao() {
        return repository.getLisNgayTao();
    }

    @Override
    public ArrayList<String> getLisNgayThanhToan() {
        return repository.getLisNgayThanhToan();
    }
    
}
