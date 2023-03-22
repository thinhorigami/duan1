package Domainmodel;

import com.nhom2.duan1.utilities.lib.annotation.SwingTable;
import com.nhom2.duan1.utilities.lib.annotation.SwingTableHeader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;
import java.util.Date;

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
    @NotNull(message = " \"ten\" cannot null ")
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
    private String gioiTinh;

    @DataField(name = "dia_chi")
    @SwingTableHeader(name = "dia chi")
    @Size(max = 10000)
    private String DiaChi;

    @DataField(name = "so_dien_thoai")
    @SwingTableHeader(name = "so dien thoai")
    private String soDienThoai;
    
    @SwingTableHeader(name = "CCCD")
    @DataField(name = "cccd")
    private String cccd;
    
    @DataField(name = "ngay_sinh")
    @SwingTableHeader(name = "ngay sinh")
    private Date ngaySinh;
    
    @DataField(name = "mat_khau")
    private String password;

    @DataField(name = "trang_thai")
    @SwingTableHeader(name = "trang thai")
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String email, String gioiTinh, String DiaChi, String soDienThoai, String cccd, Date ngaySinh, String password, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.password = password;
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
