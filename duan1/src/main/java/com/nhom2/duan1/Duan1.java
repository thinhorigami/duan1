/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import com.nhom2.duan1.View.register.TestRegister;
import com.nhom2.duan1.model.NhanVien;
import com.nhom2.duan1.repository.NhanVienRepository;
import com.nhom2.duan1.serviceImpl.NhanVienServiceImpl;
import java.sql.SQLException;


/**
 *
 * @author thinhorigami
 */
public class Duan1 {

    public static void main(String[] args) throws SQLException {
        try {
            NhanVien nv = new NhanVienServiceImpl().getAll().get(0);
            System.out.println(new NhanVienRepository().generateInsertQuery(nv));
            new TestRegister().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
