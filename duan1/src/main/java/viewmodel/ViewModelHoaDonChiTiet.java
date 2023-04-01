package viewmodel;

import Domainmodel.ChiTietSanPham;
import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class ViewModelHoaDonChiTiet {
    
    private String idsp;
    private String TenSP;
    private String TenNSX;
    private String Ten_mau;
    private String Ten_dong_SP;
    private String Ten_chat_lieu;
    private int So_size;
    private String mo_ta;
    private int so_luong_mua;
    private Double gia_ban;
    private int trangThai;
    private Double tongTien;
    
    public ViewModelHoaDonChiTiet() {
    }
    
    public ViewModelHoaDonChiTiet(String idsp, String TenSP, String TenNSX, String Ten_mau, String Ten_dong_SP, String Ten_chat_lieu, int So_size, String mo_ta, int so_luong_mua, Double gia_ban, int trangThai) {
        this.idsp = idsp;
        this.TenSP = TenSP;
        this.TenNSX = TenNSX;
        this.Ten_mau = Ten_mau;
        this.Ten_dong_SP = Ten_dong_SP;
        this.Ten_chat_lieu = Ten_chat_lieu;
        this.So_size = So_size;
        this.mo_ta = mo_ta;
        this.so_luong_mua = so_luong_mua;
        this.gia_ban = gia_ban;
        this.trangThai = trangThai;
    }
    
    public ViewModelHoaDonChiTiet(String idsp, String TenSP, String TenNSX, String Ten_mau, String Ten_dong_SP, String Ten_chat_lieu, int So_size, String mo_ta, int so_luong_mua, Double gia_ban) {
        this.idsp = idsp;
        this.TenSP = TenSP;
        this.TenNSX = TenNSX;
        this.Ten_mau = Ten_mau;
        this.Ten_dong_SP = Ten_dong_SP;
        this.Ten_chat_lieu = Ten_chat_lieu;
        this.So_size = So_size;
        this.mo_ta = mo_ta;
        this.so_luong_mua = so_luong_mua;
        this.gia_ban = gia_ban;
    }
    
    public ViewModelHoaDonChiTiet(String TenSP, String TenNSX, String Ten_mau, String Ten_dong_SP, String Ten_chat_lieu, int So_size, String mo_ta, int so_luong_mua, Double gia_ban) {
        this.TenSP = TenSP;
        this.TenNSX = TenNSX;
        this.Ten_mau = Ten_mau;
        this.Ten_dong_SP = Ten_dong_SP;
        this.Ten_chat_lieu = Ten_chat_lieu;
        this.So_size = So_size;
        this.mo_ta = mo_ta;
        this.so_luong_mua = so_luong_mua;
        this.gia_ban = gia_ban;
    }
    
    public ViewModelHoaDonChiTiet(String TenSP, String TenNSX, String Ten_mau, String Ten_dong_SP, String Ten_chat_lieu, int So_size, String mo_ta, int so_luong_mua, Double gia_ban, Double tongTien) {
        this.TenSP = TenSP;
        this.TenNSX = TenNSX;
        this.Ten_mau = Ten_mau;
        this.Ten_dong_SP = Ten_dong_SP;
        this.Ten_chat_lieu = Ten_chat_lieu;
        this.So_size = So_size;
        this.mo_ta = mo_ta;
        this.so_luong_mua = so_luong_mua;
        this.gia_ban = gia_ban;
        this.tongTien = so_luong_mua * gia_ban;
    }
    
    public String getIdsp() {
        return idsp;
    }
    
    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }
    
    public String getTenSP() {
        return TenSP;
    }
    
    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
    
    public String getTenNSX() {
        return TenNSX;
    }
    
    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }
    
    public String getTen_mau() {
        return Ten_mau;
    }
    
    public void setTen_mau(String Ten_mau) {
        this.Ten_mau = Ten_mau;
    }
    
    public String getTen_dong_SP() {
        return Ten_dong_SP;
    }
    
    public void setTen_dong_SP(String Ten_dong_SP) {
        this.Ten_dong_SP = Ten_dong_SP;
    }
    
    public String getTen_chat_lieu() {
        return Ten_chat_lieu;
    }
    
    public void setTen_chat_lieu(String Ten_chat_lieu) {
        this.Ten_chat_lieu = Ten_chat_lieu;
    }
    
    public int getSo_size() {
        return So_size;
    }
    
    public void setSo_size(int So_size) {
        this.So_size = So_size;
    }
    
    public String getMo_ta() {
        return mo_ta;
    }
    
    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
    
    public int getSo_luong_mua() {
        return so_luong_mua;
    }
    
    public void setSo_luong_mua(int so_luong_mua) {
        this.so_luong_mua = so_luong_mua;
    }
    
    public Double getGia_ban() {
        return gia_ban;
    }
    
    public void setGia_ban(Double gia_ban) {
        this.gia_ban = gia_ban;
    }
    
    public Double getTongTien() {
        return so_luong_mua * gia_ban;
    }
    
    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    public int getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String status(int trangThai) {
        String st = "";
        st = trangThai == 0 ? "Đang bán" : "Không còn bán";
        return st;
    }
    
    public Object[] dataRow() {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return new Object[]{TenSP, TenNSX, Ten_mau, Ten_dong_SP, Ten_chat_lieu, So_size, mo_ta, so_luong_mua, df.format(gia_ban)};
    }
}
