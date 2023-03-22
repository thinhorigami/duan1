
package com.nhom2.duan1.model;

import com.nhom2.duan1.utilities.lib.Gender;
import com.nhom2.duan1.utilities.lib.UserState;
import com.nhom2.duan1.utilities.lib.annotation.SwingTable;
import com.nhom2.duan1.utilities.lib.annotation.SwingTableHeader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.nhom2.duan1.utilities.lib.annotation.data.DataField;
import com.nhom2.duan1.utilities.lib.annotation.data.DataTable;

/**
 * Nhanvien
 */
@SwingTable
@DataTable(name = "NhanVien")
public class NhanVien {

  @DataField(name = "ma")
  @SwingTableHeader(name = "ma")
  @NotNull(message = "\"ma\" cannot null")
  @NotEmpty
  @NotBlank
  private String ma;

  @DataField(name = "ten")
  @SwingTableHeader(name = "ten")
  @NotNull(message =" \"ten\" cannot null ")
  @Size(max = 1000)
  @NotEmpty
  @NotBlank
  private String ten;

  @DataField(name = "email")
  @SwingTableHeader(name = "email")
  @Email
  private String email;

  @DataField(name = "gioi_tinh")
  @SwingTableHeader(name = "gioi tinh")
  private Gender gioiTinh;

  @DataField(name = "dia_chi")
  @SwingTableHeader(name = "dia chi")
  @Size(max = 10000)
  private String DiaChi;

  @DataField(name = "so_dien_thoai")
  @SwingTableHeader(name = "so dien thoai")
  private String soDienThoai;
  
  @DataField(name = "mat_khau")
  private String password;

  @DataField(name = "trang_thai")
  @SwingTableHeader(name = "trang thai")
  private UserState trangThai;

  public NhanVien() {
  }

  public NhanVien(String ma, String ten, String email, Gender gioiTinh, String diaChi, String soDienThoai,
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