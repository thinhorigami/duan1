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

    public boolean insert(NhanVien _nv) {
        try {
            return this.repo.insert(_nv);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean update(NhanVien _nhan_vien) {
        try {
            return this.repo.update(_nhan_vien);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean login(String _id, String _password) {
        try {
            return this.repo.login(_id, _password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
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
}
