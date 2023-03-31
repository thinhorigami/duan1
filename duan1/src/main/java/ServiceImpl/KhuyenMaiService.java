package ServiceImpl;

import viewmodel.KhuyenMaiViewmodel;
import Repositories.KhuyenMaiRepository;
import Service.QLKhuyenMai;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhuyenMaiService implements QLKhuyenMai {

    KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMaiViewmodel> getAll() {
        try {
            return khuyenMaiRepository.getAll();
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean add(KhuyenMaiViewmodel n) {
        try {
            khuyenMaiRepository.add(n);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public boolean update(String ma, KhuyenMaiViewmodel n) {
        try {
            khuyenMaiRepository.update(ma, n);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            khuyenMaiRepository.delete(ma);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

   @Override
    public List<KhuyenMaiViewmodel> timKiem(String ten) {
        List<KhuyenMaiViewmodel> spS = new ArrayList<>();
        try {
            for (KhuyenMaiViewmodel x : khuyenMaiRepository.getAll()) {
                if (x.getTenKM().toLowerCase().contains(ten.toLowerCase())) {
                    spS.add(x);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return spS;
    }

    @Override
    public ArrayList<KhuyenMaiViewmodel> timKiemTheoTen(String ten) {
       try {
            return khuyenMaiRepository.timKiemTheoTen(ten);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<KhuyenMaiViewmodel> locTheoTrangThai(int trangThai) {
       try {
            return khuyenMaiRepository.locTheoTrangThai(trangThai);
        } catch (Exception e) {
            return null;
        }
    }

}
