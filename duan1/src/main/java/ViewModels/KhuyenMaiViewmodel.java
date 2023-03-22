/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;



public class KhuyenMaiViewmodel {

    private int id;
    private String ma;  
    private String tenKM; 
    private String ngayBatDau;
    private String ngayKetThuc; 
    private Integer muc_giam_gia;  
    private Boolean donVi;  
    private String moTa;
    private String trangThai;

    public KhuyenMaiViewmodel(int id, String ma, String tenKM, String ngayBatDau, String ngayKetThuc, Integer muc_giam_gia, Boolean donVi, String moTa, String trangThai) {
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

    public KhuyenMaiViewmodel(String ma, String tenKM, String ngayBatDau, String ngayKetThuc, Integer muc_giam_gia, Boolean donVi, String moTa, String trangThai) {
        this.ma = ma;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.muc_giam_gia = muc_giam_gia;
        this.donVi = donVi;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    
    
    
    
    public KhuyenMaiViewmodel() {
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
