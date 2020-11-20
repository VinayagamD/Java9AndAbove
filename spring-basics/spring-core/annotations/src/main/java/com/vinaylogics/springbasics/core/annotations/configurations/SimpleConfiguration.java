package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfiguration {

    @Bean
    public SimpleBean simpleBean(){
        return new SimpleBean();
    }
}
