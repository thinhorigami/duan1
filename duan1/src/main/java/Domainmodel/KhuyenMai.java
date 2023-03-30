package Domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhuyenMai {

    private String Id;

    private String ma;

    private String tenKM;

    private String ngayBatDau;

    private String ngayKetThuc;

    private Integer muc_giam_gia;

    private Boolean donVi;

    private String moTa;

    private int trangThai;


}
