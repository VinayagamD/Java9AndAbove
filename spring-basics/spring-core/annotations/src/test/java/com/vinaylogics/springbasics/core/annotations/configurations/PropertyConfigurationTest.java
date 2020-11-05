package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyConfigurationTest extends BaseTestClass {

    @Override
    public Class<?> getConfigClass() {
        return PropertyConfiguration.class;
    }

    @Test
    @DisplayName("Test Property Initializer")
    public void testPropertyInitializer(){
        Address address = context.getBean(Address.class);
        System.out.println(address);
    }
}