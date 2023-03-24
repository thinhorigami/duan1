/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domainmodel;

import Utilities.annotation.SwingTable;
import Utilities.annotation.SwingTableHeader;
import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;
import javax.swing.SwingContainer;

/**
 *
 * @author nguye
 */
@DataTable(name = "ChucVu")
@SwingTable
public class ChucVu {

    @DataField(name = "id")
    private String id;

    @DataField(name = "maChucVu")
    private String ma;

    @DataField(name = "tenChucVu")
    @SwingTableHeader(name = "chức vụ")
    private String ten;

    @DataField(name = "trangthai")
    private Integer trangThai;

    public ChucVu() {
    }

    public ChucVu(String ma, String ten, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
