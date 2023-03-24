/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.ChucVu;
import Domainmodel.NhanVien;
import Repositories.ChucVuRepository;
import Service.ChucVuService;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nguye
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository repo;

    public ChucVuServiceImpl() throws SQLException {
        this.repo = new ChucVuRepository();
    }
    
    @Override
    public List<ChucVu> getAll() {
        return this.repo.getAll();
    }

    @Override
    public boolean insert(ChucVu _cv) {
        return this.repo.Insert(_cv);
    }

    @Override
    public boolean update(ChucVu _cv) {
        return this.repo.update(_cv);
    }

    @Override
    public Optional<ChucVu> getByMaNhanVien(NhanVien _nv) {
        return this.repo.
    }
    
}
