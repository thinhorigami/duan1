/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nhom2.duan1;

import antlr.debug.TraceEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.WebCamView;

/*
    @author thinhorigami (thinntph24396)

    NOTE:
    đổi lại user, password của SQL Server trong Utilities.DataConnect;
    - DEFAULT_USER, DEFAULT_PASSWORD
        mặc định:
        - DEFAULT_USER: sa
        - DEFAULT_PASSWORD: thinh123
 */
/**
 *
 * @author thinhorigami
 */
public class Application {

    public static void main(String[] args) throws SQLException, Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(1, 0, 500, 500);
        WebCamView wc = new WebCamView(f, true);
        JButton b = new JButton("click me");
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                wc.setVisible(true);
                System.out.println("hehe");
            }
        });
        
        f.add(b);
        f.setVisible(true);
    }
}
