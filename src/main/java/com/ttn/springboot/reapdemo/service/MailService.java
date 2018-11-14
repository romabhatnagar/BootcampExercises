package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    UserService userService;

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(User user) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("reaphelpline@gmail.com");
        mailMessage.setSubject("Your Password");
        User userdata = userService.findByEmail(user.getEmail());
        mailMessage.setText("This is your password : " + userdata.getPassword());
        javaMailSender.send(mailMessage);
    }

    public void sendRevokedMail(User user) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("reaphelpline@gmail.com");
        mailMessage.setSubject("Revoked");
        mailMessage.setText("Sorry you have been revoked by the admin!");
        javaMailSender.send(mailMessage);
    }
    /*static char[] generatePassword(int length) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String splChars = "!@#$%^&*";
        Random random = new Random();
        String pwd = letters + splChars + numbers;
        char[] newPassword = new char[length];

        for (int i = 0; i < length; i++) {
            newPassword[i] = pwd.charAt(random.nextInt(pwd.length()));
        }
        return newPassword;
    }*/
}

