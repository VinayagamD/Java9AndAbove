package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Inner Bean Creation")
class InnerBeanConfigTest {

    AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.register(InnerBeanConfig.class);
        context.refresh();
    }

    @Test
    void testCustomer() {
        Customer customer = context.getBean(Customer.class);
        System.out.println(customer);
        assertNotNull(customer);
        assertNotNull(customer.getPerson());
    }



    @Test
    void testSingletonCustomer() {
        Customer customer = context.getBean("SingletonBean",Customer.class);
        Customer customer2 = context.getBean("SingletonBean",Customer.class);
        System.out.println(customer);
        assertTrue(customer == customer2);
    }

    @Test
    void testPrototypeCustomer() {
        Customer customer = context.getBean("PrototypeBean",Customer.class);
        Customer customer2 = context.getBean("PrototypeBean",Customer.class);
        System.out.println(customer);
        assertFalse(customer == customer2);
    }
}