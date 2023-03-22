/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

/**
 *
 * @author 84982
 */
public class HoaDonChiTiet {

    private String idHĐCT;
    private int donGia;
    private int soLuong;
    private String giamGia;
    private float thanhTien;
    HoaDon hoaDon;
    private int trangThai;
    private String idCTSP;
    private String ghiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHĐCT, int donGia, int soLuong, String giamGia, float thanhTien, HoaDon hoaDon, int trangThai, String idCTSP, String ghiChu) {
        this.idHĐCT = idHĐCT;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
        this.hoaDon = hoaDon;
        this.trangThai = trangThai;
        this.idCTSP = idCTSP;
        this.ghiChu = ghiChu;
    }

    public String getIdHĐCT() {
        return idHĐCT;
    }

    public void setIdHĐCT(String idHĐCT) {
        this.idHĐCT = idHĐCT;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public HoaDonChiTiet(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    

}
