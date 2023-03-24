package Domainmodel;

import Utilities.annotation.SwingTable;
import Utilities.annotation.SwingTableHeader;
import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;
import java.util.Date;

/**
 * NhanVien
 */
@SwingTable
@DataTable(name = "NhanVien")
public class NhanVien {

    @DataField(name = "id")
    private String id;
    
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
    private String diaChi;

    @DataField(name = "dienThoai")
    @SwingTableHeader(name = "so dien thoai")
    private String dienThoai;
    
    @DataField(name = "ngaySinh")
    @SwingTableHeader(name = "ngay sinh")
    private Date ngaySinh;
    
    @DataField(name = "matKhau")
    private String matKhau;

    @DataField(name = "trangThai")
    @SwingTableHeader(name = "trang thai")
    private Integer trangThai;
    
    @DataField(name = "id_Chuc_Vu")
    private String idChaucVu;
    
    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String email, String gioiTinh, String diaChi, String dienThoai, Date ngaySinh, String matKhau, Integer trangThai, String idChaucVu) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
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
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdChaucVu() {
        return idChaucVu;
    }

    public void setIdChaucVu(String idChaucVu) {
        this.idChaucVu = idChaucVu;
    }

    
}
