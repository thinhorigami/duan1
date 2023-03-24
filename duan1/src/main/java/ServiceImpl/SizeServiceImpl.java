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
private SizeRepository sizeRepository = new SizeRepository();
    @Override
    public List<SizeDomain> getAll() {
        try {
            return sizeRepository.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SizeDomain getOne(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(SizeDomain ms) {
        try {
            sizeRepository.add(ms);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

   

    @Override
    public boolean delete(String id) {
        try {
            sizeRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String id, SizeDomain ms) {
        try {
            sizeRepository.update(id, ms);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
   
}
