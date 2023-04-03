/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author nguye
 */
public class SendMail {

    private String sender;
    private Properties pro;
    private Session session;
    private boolean result;
    private Thread th;

    public boolean isResult() {
        return this.result;
    }

    public SendMail() {
        this.pro = new Properties();
        this.result = false;
        this.th = new Thread();
        this.pro.putAll(new HashMap<String, String>() {
            {
                put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
                put("mail.smtp.port", "587"); //TLS Port
                put("mail.smtp.auth", "true"); //enable authentication
                put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
            }
        });
    }

    public boolean auth(String _sender, String _password) {
        try {
            this.session = Session.getInstance(pro, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(_sender, _password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void send(String _receiver, String _subject, String _message) {
        try {
            Message msg = new MimeMessage(session);
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(_receiver, true));
            msg.setSubject(_subject);
            msg.setText(_message);
            Transport.send(msg);
            result = true;
        } catch (MessagingException ex) {
            result = false;
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
