/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import Domainmodel.SizeDomain;
import java.util.List;
import viewmodel.SizeViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface SizeService {

    List<SizeViewModel> getAll();

    String add(SizeDomain sz);

    String update(SizeDomain sz, String ma);

    String delele(String ma);
}
