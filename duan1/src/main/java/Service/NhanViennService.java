/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Domainmodel.NhanVienn;
import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public interface NhanViennService {
     ArrayList<NhanVienn> getAll();
    boolean add(NhanVienn n);
    boolean update(String ma, NhanVienn n);
    boolean delete(String ma);
}
