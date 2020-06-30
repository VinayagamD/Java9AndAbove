package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.NamingDataCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class NamingDataCollectionConfigTest {

    AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.register(NamingDataCollectionConfig.class);
        context.refresh();
    }

    @Test
    void namingDataCollection() {
        NamingDataCollection namingDataCollection = context.getBean(NamingDataCollection.class);
        namingDataCollection.getNamingDataList();
    }
}