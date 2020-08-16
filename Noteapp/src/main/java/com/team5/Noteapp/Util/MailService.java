package com.team5.Noteapp.Util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.team5.Noteapp.Entity.Reset;
import com.team5.Noteapp.Repository.ResetRepository;
import com.team5.Noteapp.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ResetRepository resetRepository;

    private static Properties properties;
    private static Session session;
    private static final String username = "noteration@gmail.com";
    private static final String password = "team5eteration";

    static {
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendMail(String username) {
        Reset reset = new Reset();
        int resetCode = new Random().nextInt(900000) + 100000;
        System.out.println(resetCode);
        reset.setResetCode(resetCode);
        reset.setUserInfo(userInfoRepository.findByUsername(username).get());
        resetRepository.save(reset);
        String url="http://localhost/new-password/" + reset.getResetCode();
        String content="<a href='"+url+"'>"+url+"</a>";
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Team5"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userInfoRepository.findByUsername(username).get().getUser().getMail()));
            message.setSubject("Reset your password");
            message.setContent("Click the link to reset your password --> " + content,"text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}