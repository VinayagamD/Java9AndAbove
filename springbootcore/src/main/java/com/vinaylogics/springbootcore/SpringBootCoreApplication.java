package com.vinaylogics.springbootcore;

import com.vinaylogics.springbootcore.configs.MyConfigProperties;
import com.vinaylogics.springbootcore.core.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableConfigurationProperties({MyConfigProperties.class})
public class SpringBootCoreApplication {


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootCoreApplication.class, args);
        Sample sample1 = ctx.getBean("sample", Sample.class);
        Sample sample = ctx.getBean("sample", Sample.class);
        System.out.println(sample);
        System.out.println(sample1);
        // Sample sample = new Sample();
        // Bean name, type
        // Scope : Singleton, Prototype, Request, Session, GlobalRequest
        sample.printMessage();

        MyConfigProperties myConfigProperties = ctx.getBean("myConfigProperties", MyConfigProperties.class);
        System.out.println(myConfigProperties.getProp1());
        System.out.println(myConfigProperties.getProp2());
    }

}
