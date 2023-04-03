/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.duan1.test;

import Utilities.SendMail;
import javax.mail.MessagingException;

/**
 *
 * @author nguye
 *
 */
public class TestSendMail {

    public static void main(String[] args) throws MessagingException {
        var send_mail = new SendMail();
        send_mail.auth("thinhorigami.coder@gmail.com", "iexfhfrbrffmdrzx");
        send_mail.send("thinhntph24396@fpt.edu.vn", "hi", "chào cậu");
        System.out.println(send_mail.isResult());
    }
}
