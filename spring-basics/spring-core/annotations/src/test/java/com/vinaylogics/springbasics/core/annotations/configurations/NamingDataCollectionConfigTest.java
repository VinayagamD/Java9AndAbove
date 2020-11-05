package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.NamingDataCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamingDataCollectionConfigTest extends BaseTestClass {

    @Override
    public Class<?> getConfigClass() {
        return NamingDataCollectionConfig.class;
    }

    @Test
    @DisplayName("Order Bean Test")
    public void  testNamingCollectionOrder(){
        NamingDataCollection namingDataCollection = context.getBean(NamingDataCollection.class);
        namingDataCollection.getNamingDataList();
    }
}