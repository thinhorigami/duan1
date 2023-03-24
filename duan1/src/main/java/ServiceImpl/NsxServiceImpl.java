/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import Repositories.DongSPRepository;
import Repositories.MauSacRepository;
import Repositories.NsxRepository;
import Service.DongSanPhamService;
import Service.MauSacService;
import Service.NsxService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class NsxServiceImpl implements NsxService{
    
    NsxRepository repo = new NsxRepository();
    @Override
    public List<NSXdomain> getAll() {
        return repo.getAll();
    }

    @Override
    public NSXdomain getOne(String name) {
        return repo.getOne(name);
    }

    @Override
    public String add(NSXdomain x) {
        boolean add = repo.add(x);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(NSXdomain x, String id) {
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
