/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import Repositories.NhanVienRepository;
import java.sql.SQLException;

/**
 *
 * @author thinhorigami
 */
public class Application{

    public static void main(String[] args) throws SQLException, Exception {
        
        System.out.println(new NhanVienRepository().generateInsertQuery());
    }
}
