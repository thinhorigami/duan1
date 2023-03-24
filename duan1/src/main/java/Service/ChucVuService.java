/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Domainmodel.ChucVu;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface ChucVuService {
    
    public List<ChucVu> getAll();
    public boolean insert(ChucVu _cv);
    public boolean update(ChucVu _cv);
}
