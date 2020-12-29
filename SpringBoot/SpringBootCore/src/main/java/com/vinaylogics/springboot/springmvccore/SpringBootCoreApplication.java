package com.vinaylogics.springboot.springmvccore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCoreApplication {

    public static void main(String[] args) {
        System.out.println("SpringBootApp");
        SpringApplication.run(SpringBootCoreApplication.class, args);
    }

}
