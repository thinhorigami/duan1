/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.KhuyenMai;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author concu
 */
public interface QLKhuyenMai {
    ArrayList<KhuyenMai> getListKhuyenMai();
    
   
    String addKhuyenMai(KhuyenMai khuyenMai);
    
}
