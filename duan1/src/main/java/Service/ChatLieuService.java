/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.ChatLieuDomain;
import java.util.List;
import viewmodel.ChatLieuViewModel;

/**
 *
 * @author Asus
 */
public interface ChatLieuService {

    List<ChatLieuViewModel> getAll();
    
//    ChatLieuViewModel getOne(String Ma);

    String add(ChatLieuDomain chatLieu);

    String update(ChatLieuDomain chatLieu, String Ma);

    String delete(String Ma);
}
