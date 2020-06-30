package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Item;
import com.vinaylogics.springbasics.springannotation.model.Store;
import com.vinaylogics.springbasics.springannotation.model.StoreAuto;
import com.vinaylogics.springbasics.springannotation.model.StoreSetter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConstructorBeanConfig {

    @Bean("item")
    public Item getItem(){
        return new Item();
    }

    @Bean
    @Primary
    public Store getStore(Item item){
        return new Store(item);
    }

    @Bean("GetSetterStore")
    public Store getSetterStore(Item item){
        Store store = new Store();
        store.setItem(item);
        return store;
    }

    @Bean("getStoreSetter")
    public StoreSetter getStoreSetter(){
        StoreSetter storeSetter = new StoreSetter();
        storeSetter.setItem(getItem());
        return storeSetter;
    }

    @Bean
    @Primary
    public StoreAuto getStoreAuto(){
        return new StoreAuto();
    }
}
