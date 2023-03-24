/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.SanPhamDomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface SanPhamService {
    List<SanPhamDomain> getAll();

    SanPhamDomain getOne(String name);

    String add(SanPhamDomain x);
    
    String update(SanPhamDomain x, String id);
    
    String delete(String id);
}
