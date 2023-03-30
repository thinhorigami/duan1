package ServiceImpl;

import Domainmodel.KhuyenMai;
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
    public ArrayList<KhuyenMai> getAll() {
        try {
            return khuyenMaiRepository.getAll();
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean add(KhuyenMai n) {
        try {
            khuyenMaiRepository.add(n);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public boolean update(String ma, KhuyenMai n) {
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
    public List<KhuyenMai> timKiem(String ten) {
        List<KhuyenMai> spS = new ArrayList<>();
        try {
            for (KhuyenMai x : khuyenMaiRepository.getAll()) {
                if (x.getTenKM().toLowerCase().contains(ten.toLowerCase())) {
                    spS.add(x);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return spS;
    }

}
