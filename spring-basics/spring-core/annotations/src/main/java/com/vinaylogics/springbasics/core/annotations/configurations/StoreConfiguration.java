package com.vinaylogics.springbasics.core.annotations.configurations;

import com.vinaylogics.springbasics.core.annotations.models.Item;
import com.vinaylogics.springbasics.core.annotations.models.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StoreConfiguration {

    @Bean("item")
    public Item getItem(){
        return new Item();
    }

    @Bean
    @Primary
    public Store getStore(Item item){
        return new Store(item);
    }

    @Bean("SetterInjection")
    public Store setterInjection(Item item){
        Store store = new Store();
        store.setItem(item);
        return store;
    }

    @Bean("AutoWire")
    public Store autoWire(){
        return new Store();
    }

}
