package ServiceImpl;

import Domainmodel.SizeDomain;
import java.util.List;
import Repositories.SizeRepo;
import Service.SizeService;
import viewmodel.SizeViewModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPTSHOP
 */
public class SizeImpl implements SizeService {

    private SizeRepo re = new SizeRepo();

    @Override
    public List<SizeViewModel> getAll() {
        return re.getAll();
    }

    @Override
    public String add(SizeDomain sz) {
        boolean add = re.add(sz);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(SizeDomain sz, String ma) {
        boolean update = re.update(sz, ma);
        if (update) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String delele(String ma) {
        boolean xoa = re.delete(ma);
        if (xoa) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

}
