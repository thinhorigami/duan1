/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;
import Domainmodel.NhanVien;
import Repositories.NhanVienRepository;
import java.sql.SQLException;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import view.QuanLyNhanVien;
import view.Register;


/**
 *
 * @author thinhorigami
 */
public class Application{

    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setLayout(new MigLayout());
        f.add(new QuanLyNhanVien(), "W 100%");
        f.setVisible(true);
    }
}
