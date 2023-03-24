/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.KhuyenMai;
import Repositories.KhuyenMaiRepository;
import Service.QLKhuyenMai;
import java.util.ArrayList;

public class KhuyenMaiService implements QLKhuyenMai {

    KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMai> getListKhuyenMai() {
        return khuyenMaiRepository.getList();
    }

    @Override
    public String addKhuyenMai(KhuyenMai khuyenMai) {
        if (khuyenMaiRepository.add(khuyenMai)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

}
