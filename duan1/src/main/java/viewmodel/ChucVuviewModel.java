/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import Service.ChucVuService;
import ServiceImpl.ChucVuServiceImpl;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author nguye
 */
public class ChucVuviewModel {
    private ChucVuService chuc_vu_service;

    public ChucVuviewModel() throws SQLException {
        this.chuc_vu_service = new ChucVuServiceImpl();
    }
    
    public DefaultComboBoxModel fillComboBox() {
        
        return new DefaultComboBoxModel(chuc_vu_service
                .getAll()
                .stream()
                .map((o) -> (o.getTen()))
                .toArray(String[]::new));
    }
}
