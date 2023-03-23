package Repositories;

import java.sql.SQLException;

import Utilities.annotation.data.DataField;
import Utilities.annotation.data.DataTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import Domainmodel.NhanVien;
import Utilities.DBContext;
import Utilities.DataConnect;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class NhanVienRepository {

    private DataConnect data_connect;
    private String table;
    private List<String> fields;

    public NhanVienRepository() throws SQLException {
        this.data_connect = new DataConnect("sa", "thinh123");
        this.table = NhanVien.class.getAnnotation(DataTable.class).name();
        this.fields = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .map((o) -> (o.getAnnotation(DataField.class).name()))
                .collect(Collectors.toList());
    }

    public String generateSelectAllQuery() {

        StringBuilder sb = new StringBuilder(" SELECT ");
        for (int i = 0; i < fields.size() - 1; ++i) {
            sb.append(table + "." + fields.get(i));
            sb.append(",\n");
        }
        sb.append(table + "." + fields.get(fields.size() - 1));

        sb.append(new String(" FROM ")
                .concat(table));

        return sb.toString();
    }

    public Optional<NhanVien> mapp(ResultSet _result) throws SQLException, IllegalArgumentException, IllegalAccessException {
        NhanVien opt = new NhanVien();

        List<Field> f = Arrays.asList(NhanVien.class.getDeclaredFields())
                .stream()
                .filter((o) -> (o.isAnnotationPresent(DataField.class)))
                .collect(Collectors.toList());

        for (Field i : f) {
            i.setAccessible(true);
            i.set(opt, _result.getObject(i.getAnnotation(DataField.class).name()));
            i.setAccessible(false);
        }
        return Optional.ofNullable(opt);
    }

    public List<NhanVien> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException {
        ArrayList<NhanVien> ret = new ArrayList<>();
        String query = this.generateSelectAllQuery();
        PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
        ResultSet r = s.executeQuery();
        Optional<NhanVien> o;
        while (r.next()) {
            o = this.mapp(r);
            if (o.isPresent()) {
                ret.add(o.get());
            }
        }
        return ret;
    }
    
    public String generateInsertQuery() {
        StringBuilder sb = new StringBuilder(" INSERT INTO " + table);
        sb.append(" ( ");
        for (int i = 0; i < this.fields.size() - 1; ++i) {
            sb.append(this.fields.get(i) + ", ");
        }
        sb.append(this.fields.get(this.fields.size() - 1));
        sb.append(" ) ");
        sb.append(" VALUES (");
        for (int i = 0; i < this.fields.size(); ++i) {
            sb.append(" ? ");
            if (i < this.fields.size() - 1) {
                sb.append(" , ");
            }
        }
        sb.append(" ) ");
        System.out.println(sb.toString());
        return sb.toString();
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
        _ps.setString(10, UUID.randomUUID().toString());
        return _ps;
    }
    
    public boolean insert(NhanVien _nhan_vien) throws IllegalArgumentException, IllegalAccessException, SQLException {
        
        String query = this.generateInsertQuery();
        
        PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
        ret = this.setArgs(ret, _nhan_vien);
        return ret.executeLargeUpdate() > 0;
    }
    
    public boolean update(NhanVien _nhan_vien) throws SQLException {
        String query = """
                       UPDATE NhanVien
                       	SET ten = ?,
                       	gioi_tinh = ?,
                       	email = ?,
                       	so_dien_thoai = ?,
                       	dia_chi = ?,
                       	ngay_sinh = ?,
                       	mat_khau = ?,
                       	trang_thai = ?,
                       	id_chuc_vu = ?
                       WHERE Nhanvien.ma = ?
                       """;
        
        PreparedStatement ret = this.data_connect.getConnection().prepareStatement(query);
        ret = this.setArgs(ret, _nhan_vien);
        return ret.executeUpdate() > 0;
    }
    
    public boolean login(String _staff_id, String _password) throws SQLException {
        String query = """
                       SELECT * FROM NhanVien
                       WHERE NhanVien.ma = ? AND NhanVien.mat_khau = ?
                       """;
        PreparedStatement s = this.data_connect.getConnection().prepareStatement(query);
        s.setString(1, _staff_id);
        s.setString(2, _password);
        return s.executeQuery().isBeforeFirst();
    }
    
    public Long getMaxId() throws SQLException {
        String query = """
                       SELECT NhanVien.id FROM NhanVien
                       WHERE NhanVien.id = (SELECT MAX(NhanVien.id) FROM NhanVien)
                       """;
        ResultSet res = this.data_connect.getConnection().prepareStatement(query).executeQuery();
        res.next();
        return res.getLong("id");
    }
}
