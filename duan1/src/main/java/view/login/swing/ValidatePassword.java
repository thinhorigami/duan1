/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.login.swing;

import Utilities.VietNamPattern;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nguye
 */
public class ValidatePassword extends JPasswordField {

  public String pattern;
  public String err_msg;
  public JLabel err_label;

  public ValidatePassword() {
    this.pattern = new String(VietNamPattern.PASSWORD);
    this.err_msg = new String("mật khẩu chưa đủ mạnh");
    this.err_label = new JLabel();
    init();
  }

  // @param _pattern | regex đểcheck vaildate
  // @Param _err_msg | mesage khi faildate fail
  // @param _err_label | label để hiện _err_msg
  public ValidatePassword(String _pattern, String _err_msg, JLabel _err_label) {
    this.pattern = _pattern;
    this.err_msg = _err_msg;
    this.err_label = _err_label;
    this.err_label.setVisible(true);
    init();
  }

  public void init() {
    this.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e
      ) {
        vaildate();
      }

      @Override
      public void removeUpdate(DocumentEvent e
      ) {
        vaildate();
      }

      @Override
      public void changedUpdate(DocumentEvent e
      ) {
        vaildate();
      }
    }
    );
    this.err_label.setForeground(Color.ORANGE);
  }

  public void setPattern(String _pattern) {
    this.pattern = _pattern;
  }

  public void setErrorMsg(String _err_msg) {
    this.err_msg = _err_msg;
  }

  public JLabel getLabel() {
    return this.err_label;
  }

  public void vaildate() {
    if (new String(this.getPassword()).matches(this.pattern)) {
      this.err_label.setText("");
    } else {
      this.err_label.setText(this.err_msg);
    }
    System.out.println(err_label.getText());
    System.out.println(getText());
  }

  public boolean isResult() {
    return this.err_label.getText().isEmpty();
  }

  @Override
  public void setText(String t) {
    super.setText(t); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    this.err_label.setText("");
  }
}
