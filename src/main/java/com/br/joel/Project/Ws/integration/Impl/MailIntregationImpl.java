package com.br.joel.Project.Ws.integration.Impl;

import com.br.joel.Project.Ws.integration.MailIntregation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailIntregationImpl implements MailIntregation {

    private final JavaMailSender javaMailSender1;


    public MailIntregationImpl(JavaMailSender javaMailSender1) {
        this.javaMailSender1 = javaMailSender1;
    }

    @Override
    public void send(String to, String message) {
        try {
            SimpleMailMessage simple = new SimpleMailMessage();
            simple.setTo(to);
            simple.setSubject(message);
            javaMailSender1.send(simple);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
