
package com.nhom2.duan1.model;

import com.nhom2.duan1.utilities.lib.Gender;
import com.nhom2.duan1.utilities.lib.UserState;
import com.nhom2.duan1.utilities.lib.annotation.SwingTable;
import com.nhom2.duan1.utilities.lib.annotation.SwingTableHeader;
import com.nhom2.duan1.utilities.lib.annotation.data.Field;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Nhanvien
 */
@SwingTable
public class Nhanvien {

  @Field(name = "ma")
  @SwingTableHeader(headerName = "ma")
  @NotNull(message = "\"ma\" cannot null")
  @NotEmpty
  @NotBlank
  private String ma;

  @Field(name = "ten")
  @SwingTableHeader(headerName = "ten")
  @NotNull(message =" \"ten\" cannot null ")
  @Size(max = 1000)
  @NotEmpty
  @NotBlank
  private String ten;

  @Field(name = "email")
  @SwingTableHeader(headerName = "email")
  @Email
  private String email;

  @Field(name = "gioi_tinh")
  @SwingTableHeader(headerName = "gioi tinh")
  private Gender gioiTinh;

  @Field(name = "dia_chi")
  @SwingTableHeader(headerName = "dia chi")
  @Size(max = 10000)
  private String DiaChi;

  @Field(name = "do_dien_thoai")
  @SwingTableHeader(headerName = "so dien thoai")
  private String soDienThoai;

  private String password;

  @Field(name = "trang_thai")
  @SwingTableHeader(headerName = "trang thai")
  private UserState trangThai;

  public Nhanvien() {
  }

  public Nhanvien(String ma, String ten, String email, Gender gioiTinh, String diaChi, String soDienThoai,
      String password, UserState trangThai) {
    this.ma = ma;
    this.ten = ten;
    this.email = email;
    this.gioiTinh = gioiTinh;
    DiaChi = diaChi;
    this.soDienThoai = soDienThoai;
    this.password = password;
    this.trangThai = trangThai;
  }

  public String getMa() {
    return ma;
  }

  public void setMa(String ma) {
    this.ma = ma;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Gender getGioiTinh() {
    return gioiTinh;
  }

  public void setGioiTinh(Gender gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  public String getDiaChi() {
    return DiaChi;
  }

  public void setDiaChi(String diaChi) {
    DiaChi = diaChi;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserState getTrangThai() {
    return trangThai;
  }

  public void setTrangThai(UserState trangThai) {
    this.trangThai = trangThai;
  }

}