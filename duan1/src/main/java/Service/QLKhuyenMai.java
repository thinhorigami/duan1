package Service;

import viewmodel.KhuyenMaiViewmodel;
import java.util.ArrayList;
import java.util.List;

public interface QLKhuyenMai {

    ArrayList<KhuyenMaiViewmodel> getAll();

    boolean add(KhuyenMaiViewmodel n);

    boolean update(String ma, KhuyenMaiViewmodel n);

    boolean delete(String ma);

    List<KhuyenMaiViewmodel> timKiem(String ten);

    ArrayList<KhuyenMaiViewmodel> timKiemTheoTen(String ten);
 ArrayList<KhuyenMaiViewmodel> locTheoTrangThai(int trangThai);
}
