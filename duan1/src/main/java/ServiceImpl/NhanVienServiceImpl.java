/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.ChucVu;
import Domainmodel.NhanVien;
import Repositories.NhanVienRepository;
import Service.NhanVienService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class NhanVienServiceImpl implements NhanVienService {

  private NhanVienRepository repo;

  public NhanVienServiceImpl() throws SQLException {
    this.repo = new NhanVienRepository();
  }

  public List<NhanVien> getAll() {
    try {
      return this.repo.getAll();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ArrayList<>();
    }
  }

  public Optional<NhanVien> insert(NhanVien _nv) {
    try {
      return this.repo.insert(_nv);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      return Optional.empty();
    }
  }

  public Optional<NhanVien> update(NhanVien _nhan_vien) {
    try {
      return this.repo.update(_nhan_vien);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
      return Optional.empty();
    }
  }

  public Optional<NhanVien> login(String _id, String _password) {
    try {
      return this.repo.login(_id, _password);
    } catch (Exception ex) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<ChucVu> getChucVu(NhanVien _nv) {
    return this.repo.getChucVu(_nv);
  }

  @Override
  public Optional<NhanVien> getByMa(String _ma) {
    return this.repo.getByMa(_ma);
  }
  
  @Override
  public Optional<NhanVien> getByMa(String _ma, int _trang_thai) {
    return this.repo.getByMa(_ma, _trang_thai);
  }

  @Override
  public Optional<NhanVien> forgotPassword(NhanVien _nv, String _newPassword) throws SQLException {

    if (_newPassword.compareTo(_nv.getMatKhau()) == 0) {
      Optional.empty();
    }

    _nv.setMatKhau(_newPassword);;
    this.repo.update(_nv);
    return Optional.ofNullable(_nv);
  }

  @Override
  public Optional<NhanVien> exists(NhanVien _nv) throws SQLException {
    return this.repo.exists(_nv);
  }

  @Override
  public Optional<NhanVien> getByEmail(String _email) {
    return this.repo.getByEmail(_email);
  }

  @Override
  public long countAll() {
    try {
      return this.repo.CountAll();
    } catch (SQLException ex) {
      Logger.getLogger(NhanVienServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return 0;
  }

  @Override
  public List<NhanVien> getByTrangThai(int _trang_thai) throws SQLException, IllegalAccessException {
    return this.repo.getBytrangThai(_trang_thai);
  }
  
  
}
