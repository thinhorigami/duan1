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
        new SendMail("")
                .auth("")
                .send("", "hi", "chào cậu");
    }
}
