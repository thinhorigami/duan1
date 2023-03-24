/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

import java.util.Vector;

/**
 *
 * @author FPTSHOP
 */
public class SizeDomain {

    private String id;
    private String ma;
    private String soSize;
    private int trangThai;

    public SizeDomain() {
    }

    public SizeDomain(String id, String ma, String soSize, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.soSize = soSize;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSoSize() {
        return soSize;
    }

    public void setSoSize(String soSize) {
        this.soSize = soSize;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Vector<?> toDataRow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
  
   

    
}
