package com.vinaylogics.springboot.springdatajpa.runners;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springdatajpa.models.Message;
import com.vinaylogics.springboot.springdatajpa.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.LongStream;

@Configuration
public class InitializeRunner implements ApplicationRunner {
    private Faker faker;

    private final MessageRepository repository;

    public InitializeRunner(MessageRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init(){
        faker = new Faker();
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Message> messageList  = repository.findAll();
        if(messageList.isEmpty()) {
            LongStream.rangeClosed(1, 100).forEach(i -> {
                Message message = new Message();
                message.setName(faker.funnyName().name());
                message.setMessage(faker.food().dish());
                repository.save(message);
            });
        }
    }
}
