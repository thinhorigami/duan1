/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.NhanVien;
import Repositories.NhanVienRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class NhanVienServiceImpl {

    private NhanVienRepository repo;

    public NhanVienServiceImpl() throws SQLException {
        this.repo = new NhanVienRepository();
    }
    
    public String[] toStrings(NhanVien _v) {
        return new String[] {
            _v.getGioiTinh().toString(),
            _v.getMa().toString()
        };
    }

    public List<NhanVien> getAll(){
        try {
            return this.repo.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public Long getMaxId() throws SQLException {
        return this.repo.getMaxId();
    }
    
    public boolean insert(NhanVien _nv) throws IllegalArgumentException, IllegalAccessException, SQLException {
        return this.repo.insert(_nv);
    }
    
    public boolean update(NhanVien _nhan_vien) throws SQLException {
        return this.repo.update(_nhan_vien);
    }
    
    public boolean login(String _id, String _password) throws SQLException {
        return this.repo.login(_id, _password);
    }
}
