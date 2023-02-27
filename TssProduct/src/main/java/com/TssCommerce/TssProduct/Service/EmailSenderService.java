package com.TssCommerce.TssProduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private JavaMailSender javaMailSender;

    public void SendEmail(String toEmail,
                          String subject,
                          String body)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gmborsalino@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setSubject(body);

        javaMailSender.send(simpleMailMessage);
        System.out.println("Mail sent succefully.....");

    }

}
