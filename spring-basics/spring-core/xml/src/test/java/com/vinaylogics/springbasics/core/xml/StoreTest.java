package com.vinaylogics.springbasics.core.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest extends BaseTestClass {

    @Override
    public String getConfigFile() {
        return "spring-config.xml";
    }

    @Test
    @DisplayName("Test Constructor Injection")
    public void testConstructorInjection(){
        Store store = (Store) context.getBean("storeConstructor");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @Test
    @DisplayName("Test Setter Injection")
    public void testSetterInjection(){
        Store store = (Store) context.getBean("storeSetter");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @Test
    @DisplayName("Test Autowire Injection")
    public void testAutoWireInjection(){
        Store store = (Store) context.getBean("storeFieldByName");
        assertNotNull(store);
        assertNotNull(store.getItem());
        store = (Store) context.getBean("storeFieldByType");
        assertNotNull(store);
        assertNotNull(store.getItem());
        store = (Store) context.getBean("storeAutoConstructor");
        assertNotNull(store);
        assertNotNull(store.getItem());

    }


}