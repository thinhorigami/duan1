/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom2.duan1;

import java.sql.SQLException;
import javax.swing.JFrame;
import view.Register;

/**
 *
 * @author thinhorigami
 */
public class Application{

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.add(new Register());
        f.setVisible(true);
    }
}
