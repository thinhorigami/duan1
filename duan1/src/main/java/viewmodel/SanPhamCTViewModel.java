/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamCTViewModel {

    private String id;
    private String tenSP;
    private String dongSP;
    private String mauSac;
    private String chatLieu;
    private String Size;
    private String Nsx;
    private int sl;
    private Double giaNhap;
    private Double giaBan;
    private String moTa;
    private int trangThai;

    public SanPhamCTViewModel() {
    }

    public SanPhamCTViewModel(String id, String tenSP, String dongSP, String mauSac, String chatLieu, String Size, String Nsx, int sl, Double giaNhap, Double giaBan, String moTa, int trangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.dongSP = dongSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.Size = Size;
        this.Nsx = Nsx;
        this.sl = sl;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getNsx() {
        return Nsx;
    }

    public void setNsx(String Nsx) {
        this.Nsx = Nsx;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
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

    public Object[] toDataRow() {
        return new Object[]{id, tenSP, dongSP, mauSac, chatLieu, Size, Nsx, sl, giaNhap, giaBan, moTa, trangThai};
    }

}
