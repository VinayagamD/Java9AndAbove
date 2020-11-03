package com.vinaylogics.springbasics.basics.di;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreWithDITest {

    @Test
    @DisplayName("Test DI")
    public void testDI(){
        Product product = new Product();
        StoreWithDI withDI = new StoreWithDI(product);
        assertNotNull(withDI);
        assertNotNull(withDI.product);
        assertEquals(withDI.product, product);
    }

}