/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ServiceImpl.*;
import Domainmodel.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public interface KhachHangImpl {
    
    ArrayList<KhachHang> getAll();
    boolean add(KhachHang n);
    boolean update(String ma, KhachHang n);
    boolean delete(String ma);
}
