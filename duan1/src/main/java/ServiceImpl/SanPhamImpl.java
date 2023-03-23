/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.SanPhamDomain;
import java.util.List;
import Repositories.SanPhamRepo;
import Service.SanPhamSer;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamImpl implements SanPhamSer {
    
    private SanPhamRepo rs = new SanPhamRepo();
    
    @Override
    public List<SanPhamViewModel> getAll() {
        return rs.getAll();
    }
    
    @Override
    public String add(SanPhamDomain sp) {
        boolean add = rs.add(sp);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
    @Override
    public String update(SanPhamDomain sp, String ma) {
        boolean up = rs.update(sp, ma);
        if (up) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
    @Override
    public String delele(String ma) {
        boolean xoa = rs.delete(ma);
        if (xoa) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
}
