/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Repositories.DongSPRepository;
import Repositories.MauSacRepository;
import Service.DongSanPhamService;
import Service.MauSacService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class DongSPServiceImpl implements DongSanPhamService{
    
    DongSPRepository repo = new DongSPRepository();
    @Override
    public List<DongSPDomain> getAll() {
        return repo.getAll();
    }

    @Override
    public DongSPDomain getOne(String name) {
        return repo.getOne(name);
    }

    @Override
    public String add(DongSPDomain x) {
        
        if(x.getTen().isEmpty()){
            return "Không được trống";
        }else{
            boolean add = repo.add(x);
            if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
        }
    }

    @Override
    public String update(DongSPDomain x, String id) {
        boolean update = repo.update(x, id);
        if (update) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = repo.delete(id);
        if (delete) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }
}
