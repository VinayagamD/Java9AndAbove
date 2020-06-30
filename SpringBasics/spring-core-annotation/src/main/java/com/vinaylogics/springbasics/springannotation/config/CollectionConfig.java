package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;

@Configuration
public class CollectionConfig {

    @Bean("listString")
    public List<String> getListString(){
        return Arrays.asList("John", "Adam", "Harry", "Adam");
    }

    @Bean("setString")
    public Set<String> getSetString(){
        return new HashSet<>(Arrays.asList("John", "Adam", "Harry", "Adam"));
    }

    @Bean("mapString")
    public Map<String,String> getMapString(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "John");
        map.put("2", "Adam");
        map.put("3", "Harry");
        map.put("4", "Adam");
        return map;
    }

    @Bean("addressProps")
    public Properties getPropsString(){
        Properties properties = new Properties();
        properties.put("1", "John");
        properties.put("2", "Adam");
        properties.put("3", "Harry");
        properties.put("4", "Adam");
        return properties;
    }

    @Bean
    @Primary
    public String name(){
        return "My Name";
    }

    @Bean("nullName")
    public String nullName(){
        return null;
    }

    @Bean
    public Address address(){
        return new Address();
    }
}
