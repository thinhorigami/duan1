package com.nhom2.duan1.utilities.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConnect {

    private Connection conn;

    public DataConnect() throws SQLException {
        try {
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BanGiay;TrustServerCertificate=true";
            this.conn = DriverManager.getConnection(
                    "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BanGiay;TrustServerCertificate=true"
                    + "user=sa;"
                    + "password=ntt123000;");
        } catch (Exception e) {

        }

        if (conn == null) {
            System.out.println("???");
        } else {
            System.out.println("hi");
        }
    }

    public ResultSet ExecStaterment(String _value, Object... _args) throws SQLException {

        PreparedStatement exec = this.conn.prepareStatement(_value);

        for (int i = 0; i < _args.length; ++i) {
            exec.setObject(i + 1, _args[i]);
        }

        ResultSet ret = exec.executeQuery();

        return ret;
    }
}
