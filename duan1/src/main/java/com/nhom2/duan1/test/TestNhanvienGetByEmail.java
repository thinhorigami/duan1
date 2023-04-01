package com.nhom2.duan1.test;

import java.sql.SQLException;

import Repositories.NhanVienRepository;

public class TestNhanvienGetByEmail {

  public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException {
    NhanVienRepository repo = new NhanVienRepository();

    repo.getByEmail("a@gmail.com").ifPresent((o) -> {
      System.out.println(o.getEmail());
    });
  }
}
