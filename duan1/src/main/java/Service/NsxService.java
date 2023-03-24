/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface NsxService {
    List<NSXdomain> getAll();

    NSXdomain getOne(String name);

    String add(NSXdomain x);
    
    String update(NSXdomain x, String id);
    
    String delete(String id);
}
