/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;


import Domainmodel.KhachHang;
import Repositories.KhachHangRepository;
import Service.KhachHangImpl;

import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public class KhachHangService implements KhachHangImpl{
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    


    @Override
    public ArrayList<KhachHang> getAll() {
        try {
            return khachHangRepository.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean add(KhachHang n) {
        try {
             khachHangRepository.add(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String ma, KhachHang n) {
        try {
            khachHangRepository.update(ma, n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            khachHangRepository.delete(ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
