/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.SanPhamDomain;
import java.util.List;
import viewmodel.SanPhamViewModel;

/**
 *
 * @author FPTSHOP
 */
public interface SanPhamSer {

    List<SanPhamViewModel> getAll();

    String add(SanPhamDomain sp);

    String update(SanPhamDomain sp, String ma);

    String delele(String ma);
}
