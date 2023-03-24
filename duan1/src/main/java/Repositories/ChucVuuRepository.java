/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChucVuu;
import Domainmodel.KhachHang;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public class ChucVuuRepository {
      public ArrayList<ChucVuu> getAll() throws SQLException {
        ArrayList<ChucVuu> n = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "select * from chucvu";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            n.add(new ChucVuu(rs.getString("id"),
                    rs.getString("maChucVu"),
                    rs.getString("tenChucVu"),
                    rs.getInt("trangThai")));
                    

        }
        return n;

    }
      
      public static void main(String[] args) throws SQLException {
        ChucVuuRepository cv = new ChucVuuRepository();
          System.out.println(cv.getAll());
    }
}
