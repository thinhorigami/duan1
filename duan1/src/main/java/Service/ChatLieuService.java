/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.ChatLieuDomain;
import Domainmodel.MauSacdomain;
import java.util.List;

/**
 *
 * @author 84961
 */
public interface ChatLieuService {
    List<ChatLieuDomain> getAll();

    ChatLieuDomain getOne(String name);

    String add(ChatLieuDomain ms);
    
    String update(ChatLieuDomain ms, String id);
    
    String delete(String id);
}
