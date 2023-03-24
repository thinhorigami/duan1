/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.MauSacdomain;
import Repositories.MauSacRepository;
import Service.MauSacService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class MauSacServiceImpl implements MauSacService{
    
    MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    public List<MauSacdomain> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSacdomain getOne(String name) {
        return mauSacRepository.getOne(name);
    }

    @Override
    public String add(MauSacdomain mauSac) {
        boolean add = mauSacRepository.add(mauSac);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(MauSacdomain mauSac, String id) {
        boolean update = mauSacRepository.update(mauSac, id);
        if (update) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = mauSacRepository.delete(id);
        if (delete) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }
}
