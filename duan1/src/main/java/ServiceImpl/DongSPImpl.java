/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.DongSPDomain;
import java.util.List;
import Repositories.DongSPRepo;

import Service.DongSPService;
import viewmodel.DongSPViewModel;

/**
 *
 * @author admin
 */
public class DongSPImpl implements DongSPService {

    DongSPRepo lsprepo = new DongSPRepo();

    @Override
    public List<DongSPViewModel> getAll() {
        return lsprepo.getAll();
    }

    @Override
    public String add(DongSPDomain lspvmd) {
        if (lspvmd.getMa().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTen().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTrangThai().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTen().matches("[a-z A-Z]+") == false) {
            return "ten phai la chu";
        }

        boolean add = lsprepo.add(lspvmd);
        if (add) {
            return "thanh cong";
        } else {
            return "that bai";
        }

    }

    @Override
    public String update(DongSPDomain lspvmd, String Ma) {
        if (lspvmd.getTen().isEmpty()) {
            return "khong duoc de trong";
        }
        if (lspvmd.getTen().matches("[a-z A-Z]+") == false) {
            return "ten phai la chu";
        }
        if (lspvmd.getTrangThai().isEmpty()) {
            return "khong duoc de trong ";
        }

        if (lspvmd.getMa().isEmpty()) {
            return "khong duoc de trong ";
        }
        boolean update = lsprepo.update(lspvmd, Ma);
        if (update) {
            return "thanh cong";
        } else {
            return "that bai";
        }
    }

    @Override
    public String delete(String Ma) {
        boolean delete = lsprepo.delete(Ma);
        if (delete) {
            return "thanh cong";
        } else {
            return "that bai";
        }
    }

}
