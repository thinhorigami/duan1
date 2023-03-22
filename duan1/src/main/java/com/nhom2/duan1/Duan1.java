/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import com.nhom2.duan1.View.register.TestRegister;
import com.nhom2.duan1.View.customer.TestCustomer;
import com.nhom2.duan1.repository.NhanvienRepository;
import java.sql.SQLException;

import com.nhom2.duan1.utilities.lib.DataConnect;

/**
 *
 * @author thinhorigami
 */
public class Duan1 {

    public static void main(String[] args) throws SQLException {
        try {
            System.out.println(new NhanvienRepository().generateSelectQuery());
            new TestRegister().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
