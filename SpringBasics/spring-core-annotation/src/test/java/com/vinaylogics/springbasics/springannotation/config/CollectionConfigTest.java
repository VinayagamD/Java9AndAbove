package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CollectionConfigTest {
    AnnotationConfigApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.register(CollectionConfig.class);
        context.refresh();
    }

    @Test
    void testAddress() {
        Address address = context.getBean(Address.class);
        address.getAddressList();
        address.getAddressSet();
        address.getAddressMap();
        address.getAddressProp();
        address.getName();
        address.getNullName();
    }
}