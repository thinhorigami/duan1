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
public class DoanhThuViewModel {
    private String ngayThanhToan;
    private int soLuong;
    private BigDecimal doanhThu;

    public DoanhThuViewModel() {
    }

    public DoanhThuViewModel(String ngayThanhToan, int soLuong, BigDecimal doanhThu) {
        this.ngayThanhToan = ngayThanhToan;
        this.soLuong = soLuong;
        this.doanhThu = doanhThu;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        return "DoanhThuViewModel{" + "ngayThanhToan=" + ngayThanhToan + ", soLuong=" + soLuong + ", doanhThu=" + doanhThu + '}';
    }
    
    
}
