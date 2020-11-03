package com.vinaylogics.springbasics.core.annotations.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class BaseTestClass {

    public AnnotationConfigApplicationContext context;


    @BeforeEach
    public void setUp(){
        context = new AnnotationConfigApplicationContext();
        context.register(SimpleConfiguration.class);
        context.refresh();
    }

}
