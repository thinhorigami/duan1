/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.serviceImpl;

import com.nhom2.duan1.model.NhanVien;
import com.nhom2.duan1.repository.NhanvienRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class NhanVienServiceImpl {

    private NhanvienRepository repo;

    public NhanVienServiceImpl() throws SQLException {
        this.repo = new NhanvienRepository();
    }
    
    public String[] toStrings(NhanVien _v) {
        return new String[] {
            _v.getGioiTinh().toString(),
            _v.getMa().toString()
        };
    }

    public List<NhanVien> getAll(){
        try {
            return this.repo.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
