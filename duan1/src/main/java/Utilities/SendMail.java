/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.HashMap;
import java.util.Properties;
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
    
    public SendMail(String _sender) {
        this.sender = _sender;
        this.pro = new Properties();
        
        this.pro.putAll( new HashMap<String, String>() {{
            	put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		put("mail.smtp.port", "587"); //TLS Port
		put("mail.smtp.auth", "true"); //enable authentication
		put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        }});
    }
    
    public SendMail auth(String _password) {
        Authenticator a = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, _password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        };
        
        this.session = Session.getInstance(pro, a);
        return this;
    }
    
    public void send(String _receiver, String _subject, String _message)
            throws MessagingException {
        Message msg = new MimeMessage(this.session);
        msg.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse(_receiver, true));
        msg.setSubject(_subject);
        msg.setText(_message);
        Transport.send(msg);
    }
}
