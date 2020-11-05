package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.LifeCycleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleBeanConfiguration {

    @Bean
    public LifeCycleBean lifeCycleBean(){
        return new LifeCycleBean();
    }
}
