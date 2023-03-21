package com.nhom2.duan1.utilities.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConnect {
  
  private Connection conn;

  public DataConnect() throws SQLException {
    this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=ntt123000;databaseName=BanGiay;TrustserverCertificate=false;emcrypt=true");
    if (conn == null) {
      System.out.println("???");
    } else System.out.println("hi");
  }

  public ResultSet ExecStaterment(String _value, Object ... _args) throws SQLException {
    
    PreparedStatement exec =  this.conn.prepareStatement(_value);
    
    for (int  i = 0; i <  _args.length; ++i) {
      exec.setObject(i+1, _args[i]);
    }

    ResultSet ret = exec.executeQuery();

    return ret;
  }
}
