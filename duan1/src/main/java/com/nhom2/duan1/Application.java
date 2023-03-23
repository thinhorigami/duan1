/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import Repositories.NhanVienRepository;
import net.miginfocom.swing.MigLayout;
import view.Register;

import java.sql.SQLException;

import javax.swing.JFrame;

/**
 *
 * @author thinhorigami
 */
public class Application{

    public static void main(String[] args) throws SQLException, Exception {
        
        JFrame f = new JFrame();
        f.setLayout(new MigLayout());
        f.add(new Register(), "W 100%");
        f.setVisible(true);
    }
}
