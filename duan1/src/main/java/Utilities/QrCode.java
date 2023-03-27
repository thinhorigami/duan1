/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author nguye
 */
public class QrCode {
    
    private BinaryBitmap bin_map;
    
    public QrCode() {
        
    }
    
    public String ReadQR(BufferedImage _img) throws NotFoundException {
        
        this.bin_map = new BinaryBitmap(
                new HybridBinarizer(
                        new BufferedImageLuminanceSource(_img)));
        Result ret = new MultiFormatReader().decode(bin_map);
        
        return ret.getText();
    }
    
    public boolean WriteQR(File _file) {
        
        return true;
    }
}
