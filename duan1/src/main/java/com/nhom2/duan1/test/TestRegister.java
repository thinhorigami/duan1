package com.nhom2.duan1.test;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.Register;

/**
 *
 * @author nguye
 */
public class TestRegister {

    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 500, 500);

        f.add(new Register() {
          @Override
          public void onLogin() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          }
        });
        f.setVisible(true);
    }
}