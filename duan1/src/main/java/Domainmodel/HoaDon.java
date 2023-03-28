/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

import java.util.Date;
import view.KhuyenMaiView;

/**
 *
 * @author 84982
 */
public class HoaDon {

    private String idHĐ;
    KhachHang khachHang;
    NhanVien nhanVien;
    private String maHĐ;
    private Date ngayTao;
    private int trangThai;
    private Date ngayThanhToan;
    KhuyenMai khuyenMai;

    public HoaDon() {
    }

    public HoaDon(String idHĐ, KhachHang khachHang, NhanVien nhanVien, String maHĐ, Date ngayTao, int trangThai, Date ngayThanhToan, KhuyenMai khuyenMai) {
        this.idHĐ = idHĐ;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHĐ = maHĐ;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
        this.khuyenMai = khuyenMai;
    }

    public HoaDon(String maHĐ, KhachHang khachHang, NhanVien nhanVien, java.sql.Date ngayTao, int trangThai, java.sql.Date ngayThanhToan, KhuyenMai khuyenMai) {

        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHĐ = maHĐ;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
        this.khuyenMai = khuyenMai;
    }

    public String getIdHĐ() {
        return idHĐ;
    }

    public void setIdHĐ(String idHĐ) {
        this.idHĐ = idHĐ;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHĐ() {
        return maHĐ;
    }

    public void setMaHĐ(String maHĐ) {
        this.maHĐ = maHĐ;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    
  public Object[] toDataRow() {
        return new Object[]{maHĐ, khachHang.getTen(), nhanVien.getTen(), ngayTao, htTrangThai(), ngayThanhToan, khuyenMai.getMuc_giam_gia()};
    }

    @Override
    public String toString() {
        return "HoaDon{ khachHang=" + khachHang.getTen() + ", nhanVien=" + nhanVien.getTen() + ", maH\u0110=" + maHĐ + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + ", ngayThanhToan=" + ngayThanhToan + ", khuyenMai=" + khuyenMai + '}';
    }
     public String htTrangThai(){
        if(trangThai==0){
            return "chưa thanh toán";
        }else{
            return "đã thanh toán";
        }
    }
}
