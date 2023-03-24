/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Domainmodel.ChucVu;
import Service.NhanVienService;
import ServiceImpl.NhanVienServiceImpl;
import Utilities.annotation.SwingTableHeader;

/**
 *
 * @author nguye
 */
public class NhanVienViewModel {
    
    NhanVienService nhan_vien;

    ChucVuService chuc_vu;
    
    public NhanVienViewModel(NhanVienService service) {
        this.service = service;
    }
}
