/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;


import Domainmodel.KhuyenMai;
import Repositories.KhuyenMaiRepository;
import Service.QLKhuyenMai;
import Utilities.hibernateConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import ViewModels.KhuyenMaiViewmodel;

/**
 *
 * @author nva20
 */
public class KhuyenMaiService implements QLKhuyenMai{
     KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public ArrayList<KhuyenMai> getListKhuyenMai() {
        return khuyenMaiRepository.getList();
    }
    
    
    @Override
     public String addKhuyenMai(KhuyenMai khuyenMai) {
        if (khuyenMaiRepository.add(khuyenMai)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }
   
    @Override
    public boolean XoaKhuyenMai(Integer id) throws SQLException {
        Connection connection = hibernateConfig.getConnection();
        String sql = "Delete from KhuyenMai where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        int index = statement.executeUpdate();
        if (index == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean SuaKhuyenMai(KhuyenMaiViewmodel khuyenMai) throws SQLException {
       KhuyenMai Km1 = new KhuyenMai();
        Km1.setMa(khuyenMai.getMa());
        Km1.setTenKM(khuyenMai.getTenKM());
        Km1.setNgayBatDau(khuyenMai.getNgayBatDau());
        Km1.setNgayKetThuc(khuyenMai.getNgayKetThuc());
        Km1.setMuc_giam_gia(khuyenMai.getMuc_giam_gia());
        Km1.setDonVi(khuyenMai.getDonVi());
        Km1.setMoTa(khuyenMai.getMoTa());
        Km1.setTrangThai(khuyenMai.getTrangThai());

        return khuyenMaiRepository.SuaKhuyenMai(Km1);
    }

    public KhuyenMaiService() {
        khuyenMaiRepository = new KhuyenMaiRepository();
    }

    public java.util.List<KhuyenMaiViewmodel> layDSKM() throws SQLException {
        java.util.List<KhuyenMai> khuyenMais = khuyenMaiRepository.layDSKM();
        java.util.List<KhuyenMaiViewmodel> qLKhuyenMais = new ArrayList<>();
        for (KhuyenMai khuyenMai : khuyenMais) {

            qLKhuyenMais.add(new KhuyenMaiViewmodel(khuyenMai.getId(), khuyenMai.getMa(),khuyenMai.getTenKM(), khuyenMai.getNgayBatDau(),
                            khuyenMai.getNgayKetThuc(), khuyenMai.getMuc_giam_gia(),khuyenMai.getDonVi(),khuyenMai.getMoTa(), khuyenMai.getTrangThai()));
        }
        return qLKhuyenMais;
    }

}
