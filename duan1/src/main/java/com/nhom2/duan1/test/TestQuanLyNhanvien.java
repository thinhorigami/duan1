/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import ServiceImpl.NhanVienServiceImpl;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;
import view.NhanVienView;
import view.QuanLyNhanVien;

/**
 *
 * @author nguye
 */
public class TestQuanLyNhanvien {

  public static void main(String[] args) throws Exception {

    try {
      URI uri = TestQuanLyNhanvien.class
              .getClassLoader().getResource("unicode.ttf").toURI();
      GraphicsEnvironment ge
              = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font
              .createFont(Font.TRUETYPE_FONT, new File(uri))
      );
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }

    var f = new JFrame();

    f.setLayout(new MigLayout());
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setBounds(0, 0, 700, 700);
    f.add(new QuanLyNhanVien(f));
    f.setVisible(true);
  }
}
