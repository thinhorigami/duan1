package Repositories;

import Domainmodel.ChucVu;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import Domainmodel.NhanVien;
import Utilities.DataConnect;
import Utilities.QueryGenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class NhanVienRepository {

    private DataConnect data_connect;
    private QueryGenerator qg;

    public NhanVienRepository() throws SQLException {
        this.data_connect = new DataConnect("sa", "thinh123");
        qg = new QueryGenerator(NhanVien.class);
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
        _ps.setString(10, _nv.getIdChaucVu());
        return _ps;
    }

    public boolean insert(NhanVien _nhan_vien) throws SQLException {

        String query = this.qg.generateInsertQuery();

        PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
        ret = this.setArgs(ret, _nhan_vien);
        return ret.executeLargeUpdate() > 0;
    }

    public PreparedStatement setUpdateArgs(PreparedStatement _ps, NhanVien _nv) throws SQLException {
        _ps = setArgs(_ps, _nv);
        _ps.setString(11, _nv.getMa());
        return _ps;
    }

    public boolean update(NhanVien _nhan_vien) throws SQLException {
        String query = this.qg.generateUpdateQuery();

        PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
        ret = this.setUpdateArgs(ret, _nhan_vien);
        ret.setString(0, query);
        return ret.executeUpdate() > 0;
    }

    public boolean login(String _staff_id, String _password) throws SQLException {
        String query = """
                       SELECT * FROM NhanVien
                       WHERE NhanVien.maNV = ? AND NhanVien.matkhau = ?
                       """;
        PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
        s.setString(1, _staff_id);
        s.setString(2, _password);
        return s.executeQuery().isBeforeFirst();
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
}
