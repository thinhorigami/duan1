/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.NSXdomain;
import java.util.List;
import viewmodel.NSXViewModel;

/**
 *
 * @author ADMIN
 */
public interface NSXService {

    List<NSXViewModel> getAll();

    String add(NSXdomain nsxd);

    String update(NSXdomain nsxd, String Ma);

    String delete(String Ma);
}
