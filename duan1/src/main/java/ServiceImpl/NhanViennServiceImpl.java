/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.NhanVienn;
import Repositories.NhanVienRepositoryy;
import Service.NhanViennService;
import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public class NhanViennServiceImpl implements NhanViennService{
    private NhanVienRepositoryy nhanVienRepositoryy = new NhanVienRepositoryy();

    @Override
    public ArrayList<NhanVienn> getAll() {
        try {
          return  nhanVienRepositoryy.getAll();
            
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean add(NhanVienn n) {
        try {
            nhanVienRepositoryy.add(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String ma, NhanVienn n) {
        try {
            nhanVienRepositoryy.update(ma, n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            nhanVienRepositoryy.delete(ma);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
