package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreConfigurationTest extends BaseTestClass {

    @Override
    public Class<?> getConfigClass() {
        return StoreConfiguration.class;
    }

    @Test
    @DisplayName("Test DI")
    public void testDI(){
        Store store = context.getBean(Store.class);
        assertNotNull(store);
        store = context.getBean("SetterInjection", Store.class);
        assertNotNull(store);
        store = context.getBean("AutoWire", Store.class);
        assertNotNull(store);
    }
}