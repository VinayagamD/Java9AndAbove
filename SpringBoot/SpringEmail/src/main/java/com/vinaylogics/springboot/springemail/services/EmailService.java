package com.vinaylogics.springboot.springemail.services;

import com.vinaylogics.springboot.springemail.dtos.EmailDTO;

public interface EmailService {

    boolean sendEmail(EmailDTO request);
}
