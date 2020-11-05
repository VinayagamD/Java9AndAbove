package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.NamingData;
import com.vinaylogics.springbasics.core.annotations.models.NamingDataCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class NamingDataCollectionConfig {
    @Bean
    @Order(3)
    public NamingData namingData1(){
        return new NamingData("name1");
    }

    @Bean
    @Order(1)
    public NamingData namingData2(){
        return new NamingData("name2");
    }

    @Bean
    @Order(2)
    public NamingData namingData3(){
        return new NamingData("name3");
    }

    @Bean
    public NamingDataCollection namingDataCollection(){
        return new NamingDataCollection();
    }
}
