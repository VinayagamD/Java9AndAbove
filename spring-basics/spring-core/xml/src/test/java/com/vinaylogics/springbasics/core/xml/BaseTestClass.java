package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTestClass {

    public abstract String getConfigFile();
    public ApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new ClassPathXmlApplicationContext(getConfigFile());
    }

    @AfterEach
    void tearDown(){
        if(context instanceof ConfigurableApplicationContext){
            ((ConfigurableApplicationContext) context).close();
        }
    }
}
