/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Repositories.ChiTietSanPhamRepository;
import Service.ChiTietSanPhamService;
import java.util.ArrayList;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{
private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    @Override
    public ArrayList<SanPhamCTViewModel> getAll() {
        try {
          return  chiTietSanPhamRepository.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean add(SanPhamCTViewModel n) {
        try {
            chiTietSanPhamRepository.add(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String ma, SanPhamCTViewModel n) {
        try {
            chiTietSanPhamRepository.update(ma, n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            chiTietSanPhamRepository.delete(ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
