/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.MauSacdomain;
import java.util.List;
import viewmodel.MauSacViewModel;

/**
 *
 * @author ADMIN
 */
public interface MauSacService {

    List<MauSacViewModel> getAll();

    String add(MauSacdomain msvmd);

    String update(MauSacdomain msvmd, String Ma);

    String delete(String Ma);
}
