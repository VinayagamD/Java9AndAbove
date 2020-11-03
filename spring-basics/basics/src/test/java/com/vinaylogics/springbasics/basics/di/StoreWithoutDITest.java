package com.vinaylogics.springbasics.basics.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreWithoutDITest {


    @Test
    public void testStoreWithoutDI(){
        StoreWithoutDI storeWithoutDI = new StoreWithoutDI();
        assertNotNull(storeWithoutDI);
        assertNull(storeWithoutDI.product);
    }
}