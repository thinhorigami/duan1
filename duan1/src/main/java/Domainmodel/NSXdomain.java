/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

/**
 *
 * @author ADMIN
 */
public class NSXdomain {

    private String id;
    private String maSP;
    private String tenSP;
    private int trangThai;

    public NSXdomain() {
    }

    public NSXdomain(String id, String maSP, String tenSP, int trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
