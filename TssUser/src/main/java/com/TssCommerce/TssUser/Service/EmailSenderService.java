package com.TssCommerce.TssUser.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void SendEmail(String toEmail,
                          String subject,
                          String body)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gmborsalino@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setSubject(body);
        simpleMailMessage.setText("blabla");

        mailSender.send(simpleMailMessage);
        System.out.println("Mail sent succefully.....");

    }
}
