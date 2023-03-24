/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.SizeDomain;
import Repositories.DongSPRepository;
import Repositories.MauSacRepository;
import Repositories.SizeRepository;
import Service.DongSanPhamService;
import Service.MauSacService;
import Service.SizeService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class SizeServiceImpl implements SizeService{
    
    SizeRepository repo = new SizeRepository();
    @Override
    public List<SizeDomain> getAll() {
        return repo.getAll();
    }

    @Override
    public SizeDomain getOne(String name) {
        return repo.getOne(name);
    }

    @Override
    public String add(SizeDomain x) {
        boolean add = repo.add(x);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(SizeDomain x, String id) {
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
