/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Label;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import view.login.swing.MyTextField;

/**
 *
 * @author nguye
 */
public class MailVerificate extends JDialog {
    
    public MailVerificate() {
        this.setLayout(new MigLayout());
        this.add(new Label("nhập mã xác nhận"), "wrap");
        this.add(new MyTextField(), "W 100%");
    }
}
