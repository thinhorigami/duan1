/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamViewModel {

    private String id;
    private String maSP;
    private String tenSP;
    private String trangThai;


    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String id, String maSP, String tenSP, String trangThai) {
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDataRow(){
        return new Object[]{id,maSP,tenSP,trangThai};
    }
    

}
