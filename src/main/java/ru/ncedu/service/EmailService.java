package ru.ncedu.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * This class EmailService for service
 * @version 1.0, 5 Feb 2021
 * @author Vladislav Semenovykh
 */
@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * This controller for processing request POST
     * The method is sending a message to the mail
     * @param toEmail
     * @param subject
     * @param message
     */
    public void sendMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("VlSemenovykh@gmail.com");
        javaMailSender.send(mailMessage);
    }
}