/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import java.sql.SQLException;
import javax.swing.JFrame;
import view.QuanLyNhanVien;
import view.Register;

/**
 *
 * @author thinhorigami
 */
public class Application{

    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.add(new QuanLyNhanVien());
        f.setVisible(true);
    }
}
