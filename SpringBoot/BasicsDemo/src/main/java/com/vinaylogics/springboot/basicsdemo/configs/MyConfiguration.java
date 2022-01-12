package com.vinaylogics.springboot.basicsdemo.configs;

import com.vinaylogics.springboot.basicsdemo.models.Person;
import com.vinaylogics.springboot.basicsdemo.models.Student;
import com.vinaylogics.springboot.basicsdemo.services.TestService;
import com.vinaylogics.springboot.basicsdemo.services.impl.TestService1;
import com.vinaylogics.springboot.basicsdemo.services.impl.TestService2;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class MyConfiguration {

    @Bean
    public String myString(){
        return "MyStringBean";
    }

    @Bean
    public Person myPerson(){
        Person person = Person.builder()
                .name(UUID.randomUUID().toString()).passion(UUID.randomUUID().toString()).build();
        return person;
    }

    @Bean(name = "studentSetter")
    public Student studentWithSetterInject(Person person){
        Student student = new Student();
        student.setPerson(person);
        return student;
    }

    @Bean(name = "studentConstDI")
    public Student studentWithConstructorInject(Person person){
        Student student = new Student(person);
        return student;
    }

    @Bean(name = "student", autowire= Autowire.BY_TYPE)
    public Student studentWithAutowireInject(){
        Student student = new Student();
        return student;
    }

    @Bean(name = "ts1")
    public TestService ts1(){
        return new TestService1();
    }

    @Bean(name = "ts2")
    public TestService ts2(){
        return new TestService2();
    }

}
