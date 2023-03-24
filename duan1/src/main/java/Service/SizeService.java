/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.SizeDomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface SizeService {
    List<SizeDomain> getAll();

    SizeDomain getOne(String name);

    String add(SizeDomain ms);
    
    String update(SizeDomain ms, String id);
    
    String delete(String id);
}
