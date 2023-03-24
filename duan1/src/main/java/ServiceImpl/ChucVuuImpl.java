/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Domainmodel.ChucVuu;
import Repositories.ChucVuuRepository;
import Service.ChucVuuService;
import java.util.ArrayList;

/**
 *
 * @author Phuong Bi
 */
public class ChucVuuImpl implements ChucVuuService {

    private ChucVuuRepository cv = new ChucVuuRepository();

    @Override
    public ArrayList<ChucVuu> getAll() {
        try {
            return cv.getAll();
            

        } catch (Exception e) {
            return null;
        }
    }

}
