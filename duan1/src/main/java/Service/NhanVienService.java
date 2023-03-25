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
    public boolean login(String _name, String _password);
    public Optional<NhanVien>  forgotPassword(NhanVien _nv, String _newPassword) throws SQLException;
    public List<NhanVien> getAll();
    public boolean insert(NhanVien _nv);
    public boolean update(NhanVien _nv);
    public Optional<ChucVu> getChucVu(NhanVien _nv);
    public Optional<NhanVien> getByMa(String _ma);
}
