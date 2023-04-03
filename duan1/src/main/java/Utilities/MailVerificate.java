/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import view.login.swing.MyTextField;

/**
 *
 * @author nguye
 */
public class MailVerificate extends JDialog {

    private Thread time_thread;
    private Date start_date;
    private MyTextField code;
    private JLabel time_count;
    private boolean result;
    
    public MailVerificate() {
        this.time_count = new JLabel("", SwingConstants.CENTER);
        this.result = false;
        this.code = new MyTextField();
        this.setLayout(new MigLayout("wrap", "push[center]push"));
        this.add(new Label("nhập mã xác nhận"), "wrap");
        this.add(code, "W 75%");
        this.add(time_count, "W 25%");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                try {
                    time_thread.join(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MailVerificate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.setBounds(0, 0, 350, 150);
        this.setLocationRelativeTo(null);
    }

    public boolean Verficate(long _Verification_code) throws InterruptedException {
        this.code.setText("");
        this.start_date = new Date();
        this.time_thread = new Thread() {
            private boolean is_running;
            @Override
            public void run() {
                this.is_running = true;
                // 300000  = 5 minute
                Long time;
                while (this.is_running) {
                    time = 300000 - (new Date().getTime() - start_date.getTime());
                    if (time < 1000) {
                        result = false;
                        is_running = false;
                        setVisible(false);
                    }
                    time_count.setText(time / 1000 / 60 + ":" + time / 1000 % 60);
                    try {
                        if (Long.parseLong(code.getText().trim()) == _Verification_code) {
                            result = true;
                            this.is_running = false;
                            setVisible(false);
                        }
                    } catch (NumberFormatException e) {
                        // do nothing
                    }
                }
            }
        };
        this.time_thread.start();
        this.setModal(true);
        this.setVisible(true);
        return this.result;
    }

    public boolean isResult() {
        return result;
    }
    
}
