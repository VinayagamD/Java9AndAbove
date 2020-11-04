package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanInheritanceTest extends BaseTestClass {

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }

    @Test
    @DisplayName("Test Bean Inheritance")
    public void testBeanInheritance_ByProperties(){
        HelloIndia helloIndia = (HelloIndia) context.getBean("helloIndia");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

        System.out.println(helloIndia);
        System.out.println(helloWorld);
    }

    @Test
    @DisplayName("Test Bean Inheritance By Template")
    public void testBeanInheritance_ByTemplate(){
        HelloIndia helloIndia = (HelloIndia) context.getBean("helloIndia2");
        System.out.println(helloIndia);
    }


}