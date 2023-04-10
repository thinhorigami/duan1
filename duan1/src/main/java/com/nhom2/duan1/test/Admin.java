/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import Domainmodel.NhanVien;
import Service.ChucVuService;
import Service.NhanVienService;
import ServiceImpl.ChucVuServiceImpl;
import ServiceImpl.NhanVienServiceImpl;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class Admin {
  
  private NhanVien nv;
  private NhanVienService service;
  private ChucVuService cv;
  
  public Admin() throws SQLException {
    
    service = new NhanVienServiceImpl();
    cv = new ChucVuServiceImpl();
    
    service.getByEmail("nguyen.tien.thinh.thinhorigami@gmail.com")
            .ifPresentOrElse((o) -> {
              cv.getByTenChucVu("quản lý").ifPresentOrElse((c) -> {
                nv = o;
                nv.setIdChucVu(c.getId());
                service.update(nv);
              }, () -> System.out.println("không tìm thấy chức vụ"));
            }, () -> System.out.println("failed"));
  }
  
  public static void main(String[] args) throws SQLException {
    new Admin();
  }
}
