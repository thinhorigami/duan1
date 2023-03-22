/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "ma")
    private String ma;
    
    @Column(name = "ten")
    private String tenKM;
    
    @Column(name = "ngay_bat_dau")   
    private String ngayBatDau;
    
    @Column(name = "ngay_ket_thuc") 
    private String ngayKetThuc;
    
    @Column(name = "giam_gia")
    private Integer muc_giam_gia;
    
    @Column(name = "don_vi") 
    private Boolean donVi;
    
    @Column(name = "mo_ta") 
    private String moTa;
    
    @Column(name = "trang_thai")
    private String trangThai;

    public KhuyenMai(int id, String ma, String tenKM, String ngayBatDau, String ngayKetThuc, Integer muc_giam_gia, Boolean donVi, String moTa, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.muc_giam_gia = muc_giam_gia;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public KhuyenMai(String ma, String tenKM, String ngayBatDau, String ngayKetThuc, Integer muc_giam_gia, Boolean donVi, String moTa, String trangThai) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    

    
    
    

        
    
}
