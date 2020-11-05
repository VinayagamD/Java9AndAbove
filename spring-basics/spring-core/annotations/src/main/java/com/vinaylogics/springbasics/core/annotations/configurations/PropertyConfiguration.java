package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;

@Configuration
public class PropertyConfiguration {

    @Bean
    public List<String> getListString(){
        return Arrays.asList("John", "Adam", "Harry", "Adam");
    }

    @Bean
    public Set<String> getStringSet(){
        return new HashSet<>(Arrays.asList("John", "Adam", "Harry", "Adam"));
    }

    @Bean
    public Map<String,String> getStringMap(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "John");
        map.put("2", "Adam");
        map.put("3", "Harry");
        map.put("4", "Adam");
        return map;
    }

    @Bean
    public Properties getStringProperties(){
        Properties properties = new Properties();
        properties.put("1", "John");
        properties.put("2", "Adam");
        properties.put("3", "Harry");
        properties.put("4", "Adam");
        return properties;
    }

    @Bean(name = "name")
    @Primary
    public String myName(){
        return "My Name";
    }

    @Bean(name = "nullName")
    public String myNullName(){
        return null;
    }

    @Bean
    public Address address(){
        return new Address();
    }

}
