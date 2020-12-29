package com.vinaylogics.springboot.springmvccore.services.impl;

import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("ja")
public class JapanGreetingService implements GreetingService {
    @Value("${message}")
    private String message;

    @Override
    public String greeting() {
        return message;
    }
}
