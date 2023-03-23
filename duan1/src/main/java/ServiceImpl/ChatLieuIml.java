/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.ChatLieuDomain;
import java.util.List;
import Repositories.ChatLieuRepository;
import Service.ChatLieuService;
import viewmodel.ChatLieuViewModel;


/**
 *
 * @author Asus
 */
public class ChatLieuIml implements ChatLieuService {

    ChatLieuRepository chatLieuRpo = new ChatLieuRepository();

    @Override
    public List<ChatLieuViewModel> getAll() {
        return chatLieuRpo.getAll();
    }

    @Override
    public String add(ChatLieuDomain chatLieu) {
        if (chatLieu.getTen().isEmpty() || chatLieu.getMa().isEmpty()) {
            return "Cần điền thông tin";
        } else if (chatLieu.getMa().isEmpty()) {
            return "Ma trong";
        } else if (chatLieu.getTen().isEmpty()) {
            return "Ten trong";
        }
        boolean test = chatLieuRpo.add(chatLieu);
        if (test) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(ChatLieuDomain chatLieu, String Ma) {
        if (chatLieu.getTen().isEmpty()) {
            return "Ten trong";
        }
        boolean test = chatLieuRpo.update(chatLieu, Ma);
        if (test) {
            return "UpDate thành công";
        } else {
            return "UpDate thất bại";
        }
    }

    @Override
    public String delete(String Ma) {
        boolean test = chatLieuRpo.delete(Ma);
        if (test) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

//    @Override
//    public ChatlieuViewModel getOne(String Ma) {
//        return chatLieuRpo.getOne(Ma);
//    }

   

}
