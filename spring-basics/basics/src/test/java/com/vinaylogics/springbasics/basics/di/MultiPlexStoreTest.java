package com.vinaylogics.springbasics.basics.di;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiPlexStoreTest {

    @Test
    @DisplayName("Loose Coupling Without Required Type Product")
    public void testNotMultiProduct_WithoutDTypeInjection(){
        ProductNotMulti productNotMulti = new ProductNotMulti();
//        MultiPlexStore multiPlexStore = new MultiPlexStore(productNotMulti);
    }

    @Test
    @DisplayName("Loose Coupling Test With That Type Of Product")
    public void testMultiProduct_WithRequiredTypeProduct(){
        MultiProduct multiProduct = new ProductA();
        MultiPlexStore multiPlexStore = new MultiPlexStore(multiProduct);
        assertNotNull(multiPlexStore);
        assertNotNull(multiProduct);
        assertTrue(multiProduct instanceof ProductA);
        assertEquals(multiPlexStore.multiProduct.returnProductName(), "ProductA");
        assertEquals(multiPlexStore.multiProduct, multiProduct);
        multiProduct = new ProductB();
        multiPlexStore = new MultiPlexStore(multiProduct);
        assertNotNull(multiPlexStore);
        assertNotNull(multiProduct);
        assertEquals(multiPlexStore.multiProduct, multiProduct);
        assertTrue(multiProduct instanceof ProductB);
        assertEquals(multiPlexStore.multiProduct.returnProductName(), "ProductB");
    }
}