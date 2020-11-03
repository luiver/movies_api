package com.codecool.moviesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService extends SimpleMailMessage {
    private JavaMailSender emailSender;
    private static final String BOSS_EMAIL = "noreplymoviesapi@gmail.com";
    private static final String MACHINE_EMAIL = "noreplymoviesapi@gmail.com";
    private static final String ERROR_500 = "500 INTERNAL SERVER ERROR OCCURRED";

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MACHINE_EMAIL);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendDefaultSeverErrorMessage(String text){
        sendSimpleMessage(BOSS_EMAIL, ERROR_500, text);
    }

    @Autowired
    public void setEmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
}
