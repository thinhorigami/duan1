/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Domainmodel.ChucVu;
import Domainmodel.NhanVien;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nguye
 */
public interface NhanVienService {
    public Optional<NhanVien> login(String _name, String _password);
    
    public Optional<NhanVien>  forgotPassword(NhanVien _nv, String _newPassword) throws SQLException;
    
    public long countAll();
    
    // quy ước trang thái của nhân viên: 1 đang làm việc, 2 không còn làm việc
    // isPresent() == true: tồn tại _nv;
    public Optional<NhanVien> exists(NhanVien _nv) throws SQLException;
    
    public List<NhanVien> getAll();
    
    public List<NhanVien> getByTrangThai(int _trang_thai) throws SQLException, IllegalAccessException;
    
    public Optional<NhanVien> insert(NhanVien _nv);
    
    public Optional<NhanVien> update(NhanVien _nv);
    
    public Optional<ChucVu> getChucVu(NhanVien _nv);
    
    public Optional<NhanVien> getByMa(String _ma);
    
    public Optional<NhanVien> getByMa(String _ma, int _trang_thai);
    
    public Optional<NhanVien> getByEmail(String _email);
}
