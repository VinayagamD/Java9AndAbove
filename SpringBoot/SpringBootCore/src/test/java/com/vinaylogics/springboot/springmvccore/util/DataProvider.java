package com.vinaylogics.springboot.springmvccore.util;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springmvccore.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.LongStream;

@Component
public class DataProvider {

    private Faker faker;
    private List<Message> messages;

    @PostConstruct
    private void initData(){
        faker = new Faker();
        messages = new ArrayList<>();
        initializeMessage();
    }

    private void initializeMessage() {
        LongStream.rangeClosed(1,100).forEach(i->{
            messages.add(new Message(i, faker.funnyName().name(), faker.food().dish(), LocalDateTime.now()));
        });
    }

    public List<Message> provideMessage(){
        return messages;
    }
}
