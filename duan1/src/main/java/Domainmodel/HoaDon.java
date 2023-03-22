/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

import java.util.Date;

/**
 *
 * @author 84982
 */
public class HoaDon {

    private String idHĐ;
    private String maHĐ;
    private Date ngayLap;
    private Date ngayThanhToan;
    KhachHang khachHang;
    NhanVien nhanVien;
    HoaDonChiTiet hoaDonChiTiet;
    private int trangThai;
    private String ngayShip;
    private String nguoiBan;
    private String sdt;

    public HoaDon() {
    }

    public HoaDon(String maHĐ, java.sql.Date ngayThanhToan, KhachHang khachHang, NhanVien nhanVien, HoaDonChiTiet hoaDonChiTiet, int trangThai) {
        this.maHĐ = maHĐ;
        this.ngayThanhToan = ngayThanhToan;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.hoaDonChiTiet = hoaDonChiTiet;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHĐ, KhachHang khachHang, NhanVien nhanVien, java.sql.Date ngayThanhToan, int trangThai, HoaDonChiTiet hoaDonChiTiet) {
        this.maHĐ = maHĐ;
        this.ngayThanhToan = ngayThanhToan;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.hoaDonChiTiet = hoaDonChiTiet;
        this.trangThai = trangThai;
    }

    public String getIdHĐ() {
        return idHĐ;
    }

    public void setIdHĐ(String idHĐ) {
        this.idHĐ = idHĐ;
    }

    public String getMaHĐ() {
        return maHĐ;
    }

    public void setMaHĐ(String maHĐ) {
        this.maHĐ = maHĐ;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
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

    public HoaDonChiTiet getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        this.hoaDonChiTiet = hoaDonChiTiet;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(String ngayShip) {
        this.ngayShip = ngayShip;
    }

    public String getNguoiBan() {
        return nguoiBan;
    }

    public void setNguoiBan(String nguoiBan) {
        this.nguoiBan = nguoiBan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maH\u0110=" + maHĐ + ", ngayThanhToan=" + ngayThanhToan + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", hoaDonChiTiet=" + hoaDonChiTiet + ", trangThai=" + trangThai + '}';
    }

    public Object[] todataRow() {
        return new Object[]{ maHĐ, nhanVien.getTen(), khachHang.getTen(),ngayThanhToan, trangThai,hoaDonChiTiet.getThanhTien()};
    }

}
