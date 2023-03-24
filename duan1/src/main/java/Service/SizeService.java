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

    boolean add(SizeDomain ms);
    
    boolean update( String id,SizeDomain ms);
    
    boolean delete(String id);
}
