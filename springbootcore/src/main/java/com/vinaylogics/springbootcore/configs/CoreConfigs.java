package com.vinaylogics.springbootcore.configs;

import com.vinaylogics.springbootcore.models.MyModel;
import com.vinaylogics.springbootcore.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class CoreConfigs {

    @Bean
    public String name(){
        return "Name";
    }

    @Bean
    public String name2(){
        return "Name";
    }

    @Bean
    public Integer numInt(){
        return 1;
    }

    @Bean
    public Long timeStamp(){
        return System.currentTimeMillis();
    }

    @Bean
    public List<String> list(){
        return IntStream.rangeClosed(1,10).mapToObj(String::valueOf).collect(Collectors.toList());
    }

    @Bean
    public Set<String> set(List<String> list){
        return new HashSet<>(list);
    }

    @Bean
    public Map<Integer,String> map(){
        Map<Integer,String> maps = new HashMap<>();
         IntStream.rangeClosed(1,10).forEach(i->{
             maps.put(i, String.valueOf(i));
         });
         return maps;
    }

    @Bean
    public Product product(){
        Product product = new Product();
        product.setName("MyProduct");
        return product;
    }

    @Bean
    public MyModel myModel(String name, List<String> list, Set<String> set, Map<Integer,String> map, Integer data,
                           Long timeStamp, Product product){
        MyModel myModel = new MyModel();
        myModel.setName(name);
        myModel.setId(data);
        myModel.setList(list);
        myModel.setTimestamp(timeStamp);
        myModel.setMap(map);
        myModel.setProduct(product);
        return myModel;
    }
}
