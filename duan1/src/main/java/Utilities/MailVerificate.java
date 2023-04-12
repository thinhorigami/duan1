/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import view.login.swing.Button;
import view.login.swing.ButtonOutLine;
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
    private int count;
    private Button button;
    private long verification_code;

    public MailVerificate() {
        this.setResizable(false);
        this.verification_code = 0;
        this.time_count = new JLabel("", SwingConstants.CENTER);
        this.result = false;
        this.code = new MyTextField();
        this.setBackground(Color.WHITE);
        this.setLayout(new MigLayout("wrap", "push[center]push"));
        this.add(new JLabel("nhập mã xác nhận"), "wrap");
        this.add(code, "W 75%");

        this.button = new Button("Ok");
        this.button.setBackground(new Color(7, 164, 121));
        this.button.setForeground(new Color(250, 250, 250));
        this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (Long.parseLong(code.getText().trim()) == verification_code) {
                        JOptionPane.showMessageDialog(null, "xác thực email thành công");
                        result = true;
                        setVisible(false);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    // do notthing
                }
                
                count++;
                if (count < 3) {
                    JOptionPane.showMessageDialog(null, "sai mã xác thực lần " + count + " (nếu sai 3 lần bạn sẽ phải xác thực lại mail)");
                }
            }
        });

        this.add(button, "W 20%");
        this.add(time_count, "W 25%");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    time_thread.join(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MailVerificate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.setBounds(0, 0, 350, 180);
        this.setLocationRelativeTo(null);
    }

    public boolean Verficate(long _Verification_code) throws InterruptedException {
        this.verification_code = _Verification_code;
        this.code.setText("");
        this.start_date = new Date();
        this.time_thread = new Thread() {
            private boolean is_running;

            @Override
            public void run() {
                this.is_running = true;
                // 180000  = 3 minute
                Long time;
                while (this.is_running) {
                    time = 180000 - (new Date().getTime() - start_date.getTime());
                    if (time < 1000 || count == 3) {
                        result = false;
                        is_running = false;
                        setVisible(false);
                        count = 0;
                        return;
                    }
                    time_count.setText(time / 1000 / 60 + ":" + time / 1000 % 60);
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
