package Domainmodel;

import Utilities.annotation.SwingTable;
import Utilities.annotation.SwingTableHeader;
import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;
import java.util.Date;

/**
 * Nhanvien
 */
@SwingTable
@DataTable(name = "NhanVien")
public class NhanVien {

    @DataField(name = "maNV")
    @SwingTableHeader(name = "ma")
    private String ma;

    @DataField(name = "tenNV")
    @SwingTableHeader(name = "ten")
    private String ten;

    @DataField(name = "email")
    @SwingTableHeader(name = "email")
    private String email;

    @DataField(name = "gioiTinh")
    @SwingTableHeader(name = "gioi tinh")
    private String gioiTinh;

    @DataField(name = "diaChi")
    @SwingTableHeader(name = "dia chi")
    private String DiaChi;

    @DataField(name = "dienThoai")
    @SwingTableHeader(name = "so dien thoai")
    private String soDienThoai;
    
    @DataField(name = "ngayGinh")
    @SwingTableHeader(name = "ngay sinh")
    private Date ngaySinh;
    
    @DataField(name = "matKhau")
    private String password;

    @DataField(name = "trangThai")
    @SwingTableHeader(name = "trang thai")
    private String trangThai;
    
    @DataField(name = "id_Chuc_Vu")
    private int idChaucVu;
    
    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String email, String gioiTinh, String DiaChi, String soDienThoai, Date ngaySinh, String password, String trangThai, int idChaucVu) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.password = password;
        this.trangThai = trangThai;
        this.idChaucVu = idChaucVu;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public int getIdChaucVu() {
        return idChaucVu;
    }

    public void setIdChaucVu(int idChaucVu) {
        this.idChaucVu = idChaucVu;
    }
}
