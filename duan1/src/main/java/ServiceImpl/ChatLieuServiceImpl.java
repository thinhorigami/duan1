/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.ChatLieuDomain;
import Domainmodel.MauSacdomain;
import Repositories.ChatLieuRepository;
import Repositories.MauSacRepository;
import Service.ChatLieuService;
import Service.MauSacService;
import java.util.List;

/**
 *
 * @author 84961
 */
public class ChatLieuServiceImpl implements ChatLieuService{
    
    ChatLieuRepository chatLieuRepository = new ChatLieuRepository();
    @Override
    public List<ChatLieuDomain> getAll() {
        return chatLieuRepository.getAll();
    }

    @Override
    public ChatLieuDomain getOne(String name) {
        return chatLieuRepository.getOne(name);
    }

    @Override
    public String add(ChatLieuDomain cl) {
        boolean add = chatLieuRepository.add(cl);
        if (add) {
            return "Thêm Thành Công";
        } else {
            return "Thêm Thất Bại";
        }
    }

    @Override
    public String update(ChatLieuDomain cl, String id) {
        if(cl.getTen().isEmpty()){
            return "Không được để trống";
        }else{
            boolean update = chatLieuRepository.update(cl, id);
        if (update) {
            return "Sửa Thành Công";
        } else {
            return "Sửa Thất Bại";
        }
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = chatLieuRepository.delete(id);
        if (delete) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }
}
