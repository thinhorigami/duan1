/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Domainmodel.ChucVu;
import Domainmodel.NhanVien;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nguye
 */
public interface ChucVuService {
    
    public List<ChucVu> getAll();
    public boolean insert(ChucVu _cv);
    public boolean update(ChucVu _cv);
    public Optional<ChucVu> getByMaNhanVien(NhanVien _nv);
}
