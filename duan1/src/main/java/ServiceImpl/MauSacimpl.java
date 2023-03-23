/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.MauSacdomain;
import java.util.List;
import Repositories.MauSacRep;
import Service.MauSacService;
import viewmodel.MauSacViewModel;


/**
 *
 * @author ADMIN
 */
public class MauSacimpl implements MauSacService{
    MauSacRep msr = new MauSacRep();
    @Override
    public List<MauSacViewModel> getAll() {
       return msr.getAll();
    }

    @Override
    public String add(MauSacdomain msvmd) {
        if(msvmd.getMa().isEmpty()){
            return "khong duoc de trong";
        }
        if(msvmd.getTen().isEmpty()){
            return "khong duoc de trong";
        }
        boolean add = msr.add(msvmd);
        if(add){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String update(MauSacdomain msvmd, String Ma) {
        boolean update = msr.update(msvmd, Ma);
        if(update){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }

    @Override
    public String delete(String Ma) {
        boolean delete = msr.delete(Ma);
        if(delete){
            return "thanh cong";
        }
        else{
            return "that bai";
        }
    }
    
}
