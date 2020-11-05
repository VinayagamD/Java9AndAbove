package com.vinaylogics.springbasics.core.annotations.configurations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class BaseTestClass {

    public AnnotationConfigApplicationContext context;


    public abstract Class<?> getConfigClass();

    @BeforeEach
    public void setUp(){
        context = new AnnotationConfigApplicationContext();
        context.register(getConfigClass());
        context.refresh();
    }

    @AfterEach
    public void tearDown(){
        context.close();
    }

}
