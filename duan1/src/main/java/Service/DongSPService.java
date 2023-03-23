/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.DongSPDomain;
import java.util.List;
import viewmodel.DongSPViewModel;

/**
 *
 * @author admin
 */
public interface DongSPService {

    List<DongSPViewModel> getAll();

    String add(DongSPDomain lspvmd);

    String update(DongSPDomain lspvmd, String Ma);

    String delete(String Ma);
}
