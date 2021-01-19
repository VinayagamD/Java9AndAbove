package com.vinaylogics.springbaiscs.springcorexml.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing constructor and setter Injection Bean")
class StoreTest {

    ApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @DisplayName("Testing the constructor injection object")
    @Test
    public void testConstructorInjection(){
        Store store =(Store) context.getBean("store");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @DisplayName("Testing the setter injection object")
    @Test
    public void testSetterInjection(){

        Store store =(Store) context.getBean("store1");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @DisplayName("Testing the field injection by type")
    @Test
    public void testFieldInjection_ByType(){
        Store store =(Store) context.getBean("store2");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @DisplayName("Testing the field injection by name")
    @Test
    public void testFieldInjection_ByName(){
        Store store =(Store) context.getBean("store3");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @DisplayName("Testing Collection Bean")
    @Test
    public void testCollectionBean(){
        Address address = (Address) context.getBean("address");
        address.getAddressList();
        address.getAddressSet();
        address.getAddressMap();
        address.getAddressProp();
        address.getName();
        address.getNullName();
    }

}