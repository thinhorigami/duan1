/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

/**
 *
 * @author Phuong Bi
 */
public class NhanVienn {
    private String id;
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private String diaChi;
    private String matKhau;
    private String dienThoai;
    private String email;
    private int trangThai;
    private String ngaySinh;
    private String idChucVu;

    public NhanVienn() {
    }

    public NhanVienn(String id, String maNV, String tenNV, String gioiTinh, String diaChi, String matKhau, String dienThoai, String email, int trangThai, String ngaySinh, String idChucVu) {
        this.id = id;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.dienThoai = dienThoai;
        this.email = email;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
        this.idChucVu = idChucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(String idChucVu) {
        this.idChucVu = idChucVu;
    }

    @Override
    public String toString() {
        return "NhanVienn{" + "id=" + id + ", maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", dienThoai=" + dienThoai + ", email=" + email + ", trangThai=" + trangThai + ", ngaySinh=" + ngaySinh + ", idChucVu=" + idChucVu + '}';
    }

  
    
    
}
