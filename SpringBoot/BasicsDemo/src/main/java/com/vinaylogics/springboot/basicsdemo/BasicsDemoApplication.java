package com.vinaylogics.springboot.basicsdemo;

import com.vinaylogics.springboot.basicsdemo.configs.MyConfiguration;
import com.vinaylogics.springboot.basicsdemo.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicsDemoApplication {



    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(BasicsDemoApplication.class,args);
        MyConfiguration configuration = context.getBean(MyConfiguration.class);
        System.out.println(configuration.myPerson());
        System.out.println(configuration.studentWithAutowireInject());
        System.out.println(context.getBean(TestService.class));
        System.out.println(context.getBean("ts1", TestService.class));
        System.out.println(context.getBean("ts2", TestService.class));
    }
}
