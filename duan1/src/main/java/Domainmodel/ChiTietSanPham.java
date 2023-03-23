/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

/**
 *
 * @author FPTSHOP
 */
public class ChiTietSanPham {

    private String id;
    SanPhamDomain sanPhamDomain;
    NSXdomain nSXdomain;
    MauSacdomain mauSacdomain;
    DongSPDomain dongSPDomain;
    ChatLieuDomain chatLieuDomain;
    SizeDomain sizeDomain;
    private String moTa;
    private int soLuong;
    private Double giaNhap;
    private Double giaBan;
    private String anh;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id, SanPhamDomain sanPhamDomain, NSXdomain nSXdomain, MauSacdomain mauSacdomain, DongSPDomain dongSPDomain, ChatLieuDomain chatLieuDomain, SizeDomain sizeDomain, String moTa, int soLuong, Double giaNhap, Double giaBan, String anh) {
        this.id = id;
        this.sanPhamDomain = sanPhamDomain;
        this.nSXdomain = nSXdomain;
        this.mauSacdomain = mauSacdomain;
        this.dongSPDomain = dongSPDomain;
        this.chatLieuDomain = chatLieuDomain;
        this.sizeDomain = sizeDomain;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.anh = anh;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPhamDomain getSanPhamDomain() {
        return sanPhamDomain;
    }

    public void setSanPhamDomain(SanPhamDomain sanPhamDomain) {
        this.sanPhamDomain = sanPhamDomain;
    }

    public NSXdomain getnSXdomain() {
        return nSXdomain;
    }

    public void setnSXdomain(NSXdomain nSXdomain) {
        this.nSXdomain = nSXdomain;
    }

    public MauSacdomain getMauSacdomain() {
        return mauSacdomain;
    }

    public void setMauSacdomain(MauSacdomain mauSacdomain) {
        this.mauSacdomain = mauSacdomain;
    }

    public DongSPDomain getDongSPDomain() {
        return dongSPDomain;
    }

    public void setDongSPDomain(DongSPDomain dongSPDomain) {
        this.dongSPDomain = dongSPDomain;
    }

    public ChatLieuDomain getChatLieuDomain() {
        return chatLieuDomain;
    }

    public void setChatLieuDomain(ChatLieuDomain chatLieuDomain) {
        this.chatLieuDomain = chatLieuDomain;
    }

    public SizeDomain getSizeDomain() {
        return sizeDomain;
    }

    public void setSizeDomain(SizeDomain sizeDomain) {
        this.sizeDomain = sizeDomain;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    
}
