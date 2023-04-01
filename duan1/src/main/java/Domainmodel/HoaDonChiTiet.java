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
    private String maHĐCT;
    HoaDon hoaDon;
    ChiTietSanPham chiTietSanPham;
    private int soLuong;
    private Double donGia;
    

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHĐCT, String maHĐCT, HoaDon hoaDon, ChiTietSanPham chiTietSanPham, int soLuong, Double donGia) {
        this.idHĐCT = idHĐCT;
        this.maHĐCT = maHĐCT;
        this.hoaDon = hoaDon;
        this.chiTietSanPham = chiTietSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHĐCT() {
        return idHĐCT;
    }

    public void setIdHĐCT(String idHĐCT) {
        this.idHĐCT = idHĐCT;
    }

    public String getMaHĐCT() {
        return maHĐCT;
    }

    public void setMaHĐCT(String maHĐCT) {
        this.maHĐCT = maHĐCT;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

  

  
    

}
