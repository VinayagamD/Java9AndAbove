package com.vinaylogics.springbaiscs.springcorexml.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Bean Inheritance")
class HelloIndiaTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @DisplayName("Test Create Bean Inheritance Class")
    @Test()
    void testCreateBeanInherited(){
        HelloIndia helloIndia = context.getBean("helloIndia", HelloIndia.class);
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloIndia);
        System.out.println(helloWorld);
        assertEquals(helloIndia.getMessage2(), helloWorld.getMessage2());
        assertNotEquals(helloIndia.getMessage1(), helloWorld.getMessage1());
    }

    @DisplayName("Test Create Bean Inheritance Class with bean template")
    @Test()
    void testCreateBeanInheritedWithBeanTemplate(){
        HelloIndia helloIndia = context.getBean("helloIndia2", HelloIndia.class);
        System.out.println(helloIndia);
    }

    @DisplayName("Test Create InnerBean By Constructor Injection")
    @Test()
    void testCreateBeanInnerBean(){
        Customer customer = context.getBean("customer", Customer.class);
        System.out.println(customer);
        assertNotNull(customer);
        assertNotNull(customer.getPerson());
    }

    @DisplayName("Test Create InnerBean By Setter Injection")
    @Test()
    void testCreateBeanInnerBeanBySetterInjection(){
        Customer customer = context.getBean("customer2", Customer.class);
        System.out.println(customer);
        assertNotNull(customer);
        assertNotNull(customer.getPerson());
    }

    @DisplayName("Test Create Bean Scopes")
    @Test()
    void testCreateSingletonScope(){
        Customer customer = context.getBean("customerSingle", Customer.class);
        Customer customer2 = context.getBean("customerSingle", Customer.class);
        assertSame(customer, customer2);
    }

    @DisplayName("Test Create Bean Scopes Prototype")
    @Test()
    void testCreatePrototypeScope(){
        Customer customer = context.getBean("customerProto", Customer.class);
        Customer customer2 = context.getBean("customerProto", Customer.class);
        assertNotSame(customer, customer2);
    }

    @AfterEach
    void tearDown() {
    }
}