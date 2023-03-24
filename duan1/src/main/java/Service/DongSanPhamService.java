/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface DongSanPhamService {
    List<DongSPDomain> getAll();

    DongSPDomain getOne(String name);

    String add(DongSPDomain ms);
    
    String update(DongSPDomain ms, String id);
    
    String delete(String id);
}
