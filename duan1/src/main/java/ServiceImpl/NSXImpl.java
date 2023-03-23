/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.NSXdomain;
import java.util.List;
import Repositories.NSXRepository;
import viewmodel.NSXViewModel;
import Service.NSXService;

/**
 *
 * @author ADMIN
 */
public class NSXImpl implements NSXService {

    NSXRepository rs = new NSXRepository();

    @Override
    public List<NSXViewModel> getAll() {
        return rs.getAll();
    }

    @Override
    public String add(NSXdomain nsxd) {
        boolean add = rs.add(nsxd);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(NSXdomain nsxd, String ma) {
        boolean up = rs.update(nsxd, ma);
        if (up) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean xoa = rs.delete(ma);
        if (xoa) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

  

}
