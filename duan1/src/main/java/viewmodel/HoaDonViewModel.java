/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author Phuong Bi
 */
public class HoaDonViewModel {
    private String MaHD;
    private String MaSP;
    private String TenSP;
    private  Integer SoLuong;
    private BigDecimal GiaBan;
    private BigDecimal ThanhTien;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String MaHD, String MaSP, String TenSP, Integer SoLuong, BigDecimal GiaBan, BigDecimal ThanhTien) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.ThanhTien = ThanhTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    public BigDecimal getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(BigDecimal ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "MaHD=" + MaHD + ", MaSP=" + MaSP + ", TenSP=" + TenSP + ", SoLuong=" + SoLuong + ", GiaBan=" + GiaBan + ", ThanhTien=" + ThanhTien + '}';
    }
    
    
    
}
