package com.vinaylogics.springboot.springemail.services.impl;

import com.vinaylogics.springboot.springemail.dtos.EmailDTO;
import com.vinaylogics.springboot.springemail.services.EmailService;
import com.vinaylogics.springboot.springemail.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService, Constant.Email {

    private final JavaMailSender emailSender;

    @Override
    public boolean sendEmail(EmailDTO request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(new String(decoder.decode(USER_NAME)));
        message.setTo(request.getSenderEmail());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        emailSender.send(message);
        return true;
    }
}
