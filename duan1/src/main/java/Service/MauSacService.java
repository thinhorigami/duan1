/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.MauSacdomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface MauSacService {
    List<MauSacdomain> getAll();

    MauSacdomain getOne(String name);

    String add(MauSacdomain ms);
    
    String update(MauSacdomain ms, String id);
    
    String delete(String id);
}
