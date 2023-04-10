/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Frame;
import java.sql.SQLException;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author nguye
 */
public class RegisterDialog extends JDialog {

  private Register register;

  public RegisterDialog(Frame parent, boolean medal) throws SQLException, InterruptedException {
    super(parent, medal);
    this.register = new Register();
    this.setLayout(new MigLayout());
    this.add(this.register, "pos 0 0 100% 100%");
    setSize(500, 550);
    setLocationRelativeTo(null);
  }
}
