/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Domainmodel.ChiTietSanPham;
import Domainmodel.HoaDon;
import Domainmodel.KhachHang;
import Domainmodel.KhuyenMai;
import Domainmodel.NhanVien;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ViewModelHoaDonBanHang {

    String mahd;
    String tenkh;
    String tennv;
    Date ngayTao;
    int trangThai;
    Date ngayThanhToan;
    Double thanhTien;
    String maKm;
    Double giaGiam;

    public ViewModelHoaDonBanHang() {
    }

    public ViewModelHoaDonBanHang(String mahd, String tenkh, String tennv, Date ngayTao, Date ngayThanhToan) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
    }

    public ViewModelHoaDonBanHang(String mahd, String tenkh, String tennv, Date ngayTao, int trangThai, Date ngayThanhToan, Double thanhTien, String maKm) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
        this.thanhTien = thanhTien;
        this.maKm = maKm;
    }

    public ViewModelHoaDonBanHang(String mahd, String tenkh, String tennv, Date ngayTao, int trangThai, Date ngayThanhToan, Double thanhTien, String maKm, Double giaGiam) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
        this.thanhTien = thanhTien;
        this.maKm = maKm;
        this.giaGiam = giaGiam;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ViewModelHoaDonBanHang(String mahd, String tenkh, String tennv, Date ngayTao, int trangThai, Date ngayThanhToan) {
        this.mahd = mahd;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKm() {
        return maKm;
    }

    public void setMaKm(String maKm) {
        this.maKm = maKm;
    }

    public Double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Double giaGiam) {
        this.giaGiam = giaGiam;
    }

    public String status(int trangThai) {
        String st = "";
        st = trangThai == 0 ? "Chua Thanh Toan" : "Da Thanh Toan";
        return st;
    }

    public Object[] dataRow() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return new Object[]{mahd, tenkh, tennv, ngayTao, status(trangThai), ngayThanhToan, df.format(thanhTien)};
    }
}
