/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Domainmodel.ChatLieuDomain;
import Domainmodel.DongSPDomain;
import Domainmodel.MauSacdomain;
import Domainmodel.NSXdomain;
import Domainmodel.SanPhamDomain;
import Domainmodel.SizeDomain;
import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class ViewModelBanHang {

    String id;
    String tenSP;
    String tenNsx;
    String mauSac;
    String tenDong;
    String tenChatLieu;
    int soSize;
    String mota;
    int soLuongTon;
    Double giaNhap;
    Double giaBan;
    int TrangThai;

    public ViewModelBanHang() {
    }

    public ViewModelBanHang(String id, String tenSP, String tenNsx, String mauSac, String tenDong, String tenChatLieu, int soSize, String mota, int soLuongTon, Double giaNhap, Double giaBan, int TrangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.tenNsx = tenNsx;
        this.mauSac = mauSac;
        this.tenDong = tenDong;
        this.tenChatLieu = tenChatLieu;
        this.soSize = soSize;
        this.mota = mota;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenNsx() {
        return tenNsx;
    }

    public void setTenNsx(String tenNsx) {
        this.tenNsx = tenNsx;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenDong() {
        return tenDong;
    }

    public void setTenDong(String tenDong) {
        this.tenDong = tenDong;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public int getSoSize() {
        return soSize;
    }

    public void setSoSize(int soSize) {
        this.soSize = soSize;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String Status(int TrangThai) {
        String st = "";
        st = (TrangThai == 0) ? "Ngừng Bán" : "Đang Bán";
        return st;
    }

    public Object[] dataRow() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return new Object[]{id, tenSP, tenNsx, mauSac, tenDong, tenChatLieu, soSize, mota, soLuongTon, df.format(giaNhap), df.format(giaBan),Status(TrangThai)};
    }

}
