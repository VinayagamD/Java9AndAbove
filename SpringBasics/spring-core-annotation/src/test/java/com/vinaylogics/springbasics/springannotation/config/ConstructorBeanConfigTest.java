package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Store;
import com.vinaylogics.springbasics.springannotation.model.StoreAuto;
import com.vinaylogics.springbasics.springannotation.model.StoreSetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;


class ConstructorBeanConfigTest {

    AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.register(ConstructorBeanConfig.class);
        context.refresh();
    }

    @DisplayName("Test Constructor Injection")
    @Test
    void testConstructorInjection() {
      assertNotNull(context);
      Store store  = context.getBean(Store.class);
      assertNotNull(store);
      assertNotNull(store.getItem());
    }

    @DisplayName("Test Setter Injection")
    @Test
    void testSetterInjection() {
      assertNotNull(context);
      StoreSetter store  = context.getBean(StoreSetter.class);
      assertNotNull(store);
      assertNotNull(store.getItem());
    }

    @DisplayName(("Test Store Setter Injection"))
    @Test
    void testStoreSetterInjection(){
        assertNotNull(context);
        Store store  = (Store) context.getBean("GetSetterStore");
        assertNotNull(store);
        assertNotNull(store.getItem());
    }

    @DisplayName(("Test Store Autowire Injection"))
    @Test
    void testStoreAutoWire(){
        assertNotNull(context);
        StoreAuto store  =  context.getBean(StoreAuto.class);
        assertNotNull(store);
        assertNotNull(store.getItem());
        assertNotNull(store.getItemName());
    }
}