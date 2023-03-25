/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.ArrayList;
import viewmodel.SanPhamCTViewModel;

/**
 *
 * @author Phuong Bi
 */
public interface ChiTietSanPhamService {
    ArrayList<SanPhamCTViewModel> getAll();
    boolean add(SanPhamCTViewModel n);
    boolean update(String ma, SanPhamCTViewModel n);
    boolean delete(String ma);
}
