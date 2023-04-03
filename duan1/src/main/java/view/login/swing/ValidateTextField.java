package view.login.swing;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nguye
 */
public class ValidateTextField extends JTextField {

    public String pattern;
    public String err_msg;
    public JLabel err_label;
    
    public ValidateTextField() {
        this.pattern = new String("*");
        this.err_msg = new String("");
    }

    // @param _pattern | regex đểcheck vaildate
    // @Param _err_msg | mesage khi faildate fail
    // @param _err_label | label để hiện _err_msg
    public ValidateTextField(String _pattern, String _err_msg, JLabel _err_label) {
        this.pattern = _pattern;
        this.err_msg = _err_msg;
        this.err_label = _err_label;
        this.err_label.setVisible(true);
        
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                vaildate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                vaildate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                vaildate();
            }
        });
    }
    
    public JLabel getLabel() {
        return this.err_label;
    }
    
    public void vaildate() {
        if (this.getText().matches(this.pattern)) {
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
}
