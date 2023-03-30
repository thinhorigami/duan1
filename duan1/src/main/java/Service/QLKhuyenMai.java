
package Service;

import Domainmodel.KhuyenMai;
import java.util.ArrayList;
import java.util.List;

public interface QLKhuyenMai {
   
    
    ArrayList<KhuyenMai> getAll();
    boolean add(KhuyenMai n);
    boolean update(String ma, KhuyenMai n);
    boolean delete(String ma);
    List<KhuyenMai> timKiem(String ten);
   
 
}
