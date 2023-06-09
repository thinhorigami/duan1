package Repositories;

import Domainmodel.ChucVu;
import java.sql.SQLException;
// ajsbvjabvj
import java.util.ArrayList;
import java.util.List;
import Domainmodel.NhanVien;
import Utilities.DBContext;
import Utilities.QueryGenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.UUID;

public class NhanVienRepository {

  private DBContext data_connect;
  private QueryGenerator qg;

  public NhanVienRepository() throws SQLException {
    this.data_connect = new DBContext();
    qg = new QueryGenerator(NhanVien.class);
  }

  public long CountAll() throws SQLException {
    String query = """
                     SELECT COUNT(*) FROM NhanVien
                     """;
    ResultSet res = this.data_connect.getConnection()
            .prepareStatement(query)
            .executeQuery();
    res.next();
    long ret = res.getLong(1);
    return ret;
  }

  public List<NhanVien> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException {
    ArrayList<NhanVien> ret = new ArrayList<>();
    String query = this.qg.generateSelectAllQuery();
    PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
    ResultSet r = s.executeQuery();
    Optional<NhanVien> o;
    while (r.next()) {
      o = this.qg.mapp(r, new NhanVien());
      if (o.isPresent()) {
        ret.add(o.get());
      }
    }
    return ret;
  }

  public List<NhanVien> getBytrangThai(int _trang_thai) throws SQLException, IllegalAccessException {

    if (_trang_thai > 1) {
      return this.getAll();
    }

    var ret = new ArrayList<NhanVien>();
    var s = this.data_connect.getConnection().prepareStatement(this.qg.generateSelectAllQuery()
            + " WHERE NhanVien.trangThai = ?");
    s.setInt(1, _trang_thai);
    var r = s.executeQuery();
    Optional<NhanVien> o;
    while (r.next()) {
      o = this.qg.mapp(r, new NhanVien());
      if (o.isPresent()) {
        ret.add(o.get());
      }
    }
    return ret;
  }

  public PreparedStatement setArgs(PreparedStatement _ps, NhanVien _nv) throws SQLException {
    _ps.setString(1, _nv.getMa());
    _ps.setString(2, _nv.getTen());
    _ps.setString(3, _nv.getEmail());
    _ps.setString(4, _nv.getGioiTinh());
    _ps.setString(5, _nv.getDiaChi());
    _ps.setString(6, _nv.getDienThoai());
    _ps.setDate(7, new java.sql.Date(_nv.getNgaySinh().getTime()));
    _ps.setString(8, _nv.getMatKhau());
    _ps.setInt(9, _nv.getTrangThai());
    _ps.setString(10, _nv.getIdChucVu());
    return _ps;
  }

  public Optional<NhanVien> insert(NhanVien _nhan_vien) throws SQLException {

    String query = this.qg.generateInsertQuery();

    PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
    ret = this.setArgs(ret, _nhan_vien);
    if (ret.executeUpdate() > 0) {
      return Optional.of(_nhan_vien);
    }
    return Optional.empty();
  }

  public PreparedStatement setUpdateArgs(PreparedStatement _ps, NhanVien _nv) throws SQLException {
    _ps = setArgs(_ps, _nv);
    _ps.setString(11, _nv.getMa());
    return _ps;
  }

  public Optional<NhanVien> update(NhanVien _nhan_vien) throws SQLException {
    String query = this.qg.generateUpdateQuery();

    PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
    ret = this.setUpdateArgs(ret, _nhan_vien);
    if (ret.executeUpdate() > 0) {
      return Optional.of(_nhan_vien);
    }
    return Optional.empty();
  }

  public Optional<NhanVien> login(String _email, String _password) throws SQLException, IllegalAccessException {
    String query = """
                       SELECT * FROM NhanVien
                       WHERE NhanVien.email = ?
                       AND NhanVien.matkhau = ?
                       AND NhanVien.trangThai = 1
                       """;
    PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
    s.setString(1, _email);
    s.setString(2, _password);

    var r = s.executeQuery();

    if (r.next()) {
      return this.qg.mapp(r, new NhanVien());
    }
    return Optional.empty();
  }

  public Optional<ChucVu> getChucVu(NhanVien _nv) {

    try {
      QueryGenerator<ChucVu> cvqg = new QueryGenerator(ChucVu.class);
      PreparedStatement ps = this.data_connect.getConnection()
              .prepareStatement(cvqg.generateSelectAllQuery()
                      + " JOIN NhanVien ON NhanVien.id_Chuc_Vu = ChucVu.ID"
                      + " WHERE NhanVien.maNV = ? ");
      ps.setString(1, _nv.getMa());
      ResultSet res = ps.executeQuery();
      res.next();
      return cvqg.mapp(res, new ChucVu());
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return Optional.empty();
    }
  }

  public Optional<NhanVien> exists(NhanVien _nv) throws SQLException {

    String query = """
                       SELECT id from NhanVien
                       WHERE (NhanVien.email = ? OR
                       NhanVien.dienthoai = ?) AND 
                       NhanVien.trangThai = 1
                       """;
    PreparedStatement s = this.data_connect.getConnection()
            .prepareStatement(query);
    s.setString(1, _nv.getEmail());
    s.setString(2, _nv.getDienThoai());

    if (s.executeQuery().isBeforeFirst()) {
      return Optional.of(_nv);
    } else {
      return Optional.empty();
    }
  }

  public Optional<NhanVien> getByMa(String _ma) {

    try {
      PreparedStatement ps = this.data_connect.getConnection()
              .prepareStatement(this.qg.generateSelectAllQuery()
                      + " WHERE NhanVien.maNV = ? ");
      ps.setString(1, _ma);
      ResultSet res = ps.executeQuery();
      res.next();
      return this.qg.mapp(res, new NhanVien());
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return Optional.empty();
    }
  }

  public Optional<NhanVien> getByMa(String _ma, int _trang_thai) {

    if (_trang_thai > 1) {
      return this.getByMa(_ma);
    }

    try {
      PreparedStatement ps = this.data_connect.getConnection()
              .prepareStatement(this.qg.generateSelectAllQuery()
                      + " WHERE NhanVien.maNV = ? AND "
                      + " NhanVien.trangThai = ?");
      ps.setString(1, _ma);
      ps.setInt(2, _trang_thai);
      ResultSet res = ps.executeQuery();
      res.next();
      return this.qg.mapp(res, new NhanVien());
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return Optional.empty();
    }
  }

  public Optional<NhanVien> getByEmail(String _email) {
    try {
      String query = this.qg.generateSelectAllQuery()
              + " WHERE NhanVien.email = ?";
      PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
      s.setString(1, _email);
      ResultSet ret = s.executeQuery();
      ret.next();
      return this.qg.mapp(ret, new NhanVien());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Optional.empty();
    }
  }

  public boolean updateable(String _ma, String _email, String _sdt) {
    try {
      PreparedStatement ps = this.data_connect.getConnection()
              .prepareStatement(this.qg.generateSelectAllQuery()
                      + " WHERE NhanVien.maNV <> ? AND "
                      + " (NhanVien.email = ? OR "
                      + " NhanVien.dienThoai = ?) AND "
                      + " NhanVien.trangThai = 1");
      ps.setString(1, _ma);
      ps.setString(2, _email);
      ps.setString(3, _sdt);
      ResultSet res = ps.executeQuery();
      return !res.isBeforeFirst();
    } catch (Exception e) {
      return true;
    }
  }

  public Optional<NhanVien> forgetPassword(NhanVien _nv, String _new_Password) throws SQLException {
    if (_nv.getMatKhau().compareTo(_new_Password) == 0) {
      return Optional.empty();
    }
    _nv.setMatKhau(_new_Password);
    return this.update(_nv);
  }
}
