package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScopeTest extends BaseTestClass {

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }

    @Test
    @DisplayName("Scope Singleton Test")
    public void testScope_Singleton(){
        Customer customer1 = (Customer) context.getBean("customerSingleton");
        Customer customer2 = (Customer) context.getBean("customerSingleton");
        assertTrue(customer1 == customer2);
        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
    }

    @Test
    @DisplayName("Scope Prototype Test")
    public void testScope_Prototype(){
        Customer customer1 = (Customer) context.getBean("customerProto");
        Customer customer2 = (Customer) context.getBean("customerProto");
        assertFalse(customer1 == customer2);
        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
    }

    @Test
    @DisplayName("Scope Singleton Alias Test")
    public void testScope_AliasSingleton(){
        Customer customer1 = (Customer) context.getBean("customer");
        Customer customer2 = (Customer) context.getBean("customerSingleton");
        assertTrue(customer1 == customer2);
        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
    }
}