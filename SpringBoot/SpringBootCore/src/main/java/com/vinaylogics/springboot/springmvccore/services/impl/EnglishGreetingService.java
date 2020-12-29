package com.vinaylogics.springboot.springmvccore.services.impl;

import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en","default"})
public class EnglishGreetingService implements GreetingService {
    @Value("${message}")
    private String message;

    @Override
    public String greeting() {
        return message;
    }
}
