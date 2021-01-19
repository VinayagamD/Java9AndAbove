package com.vinaylogics.springboot.springemail.services.impl;

import com.vinaylogics.springboot.springemail.dtos.EmailDTO;
import com.vinaylogics.springboot.springemail.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Override
    public boolean sendEmail(EmailDTO request) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        return true;
    }
}
