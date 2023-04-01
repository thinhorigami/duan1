/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

/**
 *
 * @author concu
 */
public class KhuyenMai {

    private String Id;

    private String ma;

    private String tenKM;

    private String ngayBatDau;

    private String ngayKetThuc;

    private Integer muc_giam_gia;

    private Boolean donVi;

    private String moTa;

    private int trangThai;

    public KhuyenMai(String Id, String ma, String tenKM, String ngayBatDau, String ngayKetThuc, Integer muc_giam_gia, Boolean donVi, String moTa, int trangThai) {
        this.Id = Id;
        this.ma = ma;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.muc_giam_gia = muc_giam_gia;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public KhuyenMai() {
    }

    public KhuyenMai(String ma) {
        this.ma = ma;
    }

   
    @Override
    public String toString() {
        return "KhuyenMai{" + "Id=" + Id + ", ma=" + ma + ", tenKM=" + tenKM + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", muc_giam_gia=" + muc_giam_gia + ", donVi=" + donVi + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getMuc_giam_gia() {
        return muc_giam_gia;
    }

    public void setMuc_giam_gia(Integer muc_giam_gia) {
        this.muc_giam_gia = muc_giam_gia;
    }

    public Boolean getDonVi() {
        return donVi;
    }

    public void setDonVi(Boolean donVi) {
        this.donVi = donVi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
