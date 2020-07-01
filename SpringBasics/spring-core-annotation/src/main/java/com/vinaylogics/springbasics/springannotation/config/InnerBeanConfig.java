package com.vinaylogics.springbasics.springannotation.config;

import com.vinaylogics.springbasics.springannotation.model.Customer;
import com.vinaylogics.springbasics.springannotation.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class InnerBeanConfig {

    @Bean
    @Primary
    public Customer customer(){
        Customer customer = new Customer();
        customer.setPerson(person());
        return customer;
    }

    private Person person() {
        Person person = new Person();
        person.setAddress("Bangalore");
        person.setName("Saini");
        person.setAge(28);
        return person;
    }

    @Bean("SingletonBean")
    @Scope("singleton")
    public Customer singletonCustomer(){
        Customer customer = new Customer();
        customer.setPerson(person());
        return customer;
    }

    @Bean("PrototypeBean")
    @Scope("prototype")
    public Customer prototypeCustomer(){
        Customer customer = new Customer();
        customer.setPerson(person());
        return customer;
    }


}
