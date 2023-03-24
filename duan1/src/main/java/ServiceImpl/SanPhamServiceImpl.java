/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.SanPhamDomain;
import Repositories.DongSPRepository;
import Repositories.MauSacRepository;
import Repositories.SanPhamRepositor;
import Service.DongSanPhamService;
import Service.MauSacService;
import Service.SanPhamService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class SanPhamServiceImpl implements SanPhamService{
    
    SanPhamRepositor repo = new SanPhamRepositor();
    @Override
    public List<SanPhamDomain> getAll() {
        return repo.getAll();
    }

    @Override
    public SanPhamDomain getOne(String name) {
        return repo.getOne(name);
    }

    @Override
    public String add(SanPhamDomain x) {
        boolean add = repo.add(x);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(SanPhamDomain x, String id) {
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
