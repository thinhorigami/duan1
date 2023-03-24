/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Domainmodel.ChucVu;
import Utilities.DataConnect;
import Utilities.QueryGenerator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.Action;

/**
 *
 * @author nguye
 */
public class ChucVuRepository {
    private DataConnect conn;
    private QueryGenerator<ChucVu> qg;
    
    public ChucVuRepository() throws SQLException {
        this.conn = new DataConnect("sa", "thinh123");
        this.qg = new QueryGenerator(ChucVu.class);
    }
    
    public PreparedStatement setArgs(PreparedStatement _ps, ChucVu _cv) throws SQLException {
        _ps.setString(1, _cv.getMa());
        _ps.setString(2, _cv.getTen());
        return _ps;
    }
    
    public boolean Insert(ChucVu _cv) {
        try {
            PreparedStatement ps = this.conn
                    .getConnection()
                    .prepareStatement(this.qg.generateInsertQuery());
            ps = this.setArgs(ps, _cv);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public PreparedStatement setUpdateArgs( PreparedStatement _ps, ChucVu _cv) throws SQLException {
        _ps = setArgs(_ps, _cv);
        _ps.setString(3, _cv.getMa());
        return _ps;
    }
    
    public boolean update(ChucVu _cv) {
        try {
            PreparedStatement ps = this.conn
                    .getConnection()
                    .prepareStatement(this.qg.generateInsertQuery());
            ps = setUpdateArgs(ps, _cv);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public List<ChucVu> getAll() {
        List<ChucVu> ret = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn
                    .getConnection()
                    .prepareStatement(this.qg.generateSelectAllQuery());
            ResultSet res = ps.executeQuery();
            Optional<ChucVu> opt;
            while (res.next()) {
                opt = this.qg.mapp(res, new ChucVu());
                ret.add(opt.get());
            }
            
            return ret;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<ChucVu>();
        }
    }
    
    public Optional<ChucVu> getByTenChucVu(String _name) {
        ChucVu ret;
        try {
            PreparedStatement ps = this.conn
                    .getConnection()
                    .prepareStatement(this.qg.generateSelectAllQuery()
                    + " WHERE ChucVu.temChucVu = ?");
            ps.setString(1, _name);
            ResultSet res = ps.executeQuery();
            res.next();
            return this.qg.mapp(res, new ChucVu());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}
