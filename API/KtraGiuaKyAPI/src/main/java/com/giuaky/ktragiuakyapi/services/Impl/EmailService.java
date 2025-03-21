package com.giuaky.ktragiuakyapi.services.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendOtp(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("(Kiem Tra Giua Ky LTMB) Your OTP Code for Registration");
        message.setText("Your OTP code is: " + otp);

        emailSender.send(message);
    }
}
