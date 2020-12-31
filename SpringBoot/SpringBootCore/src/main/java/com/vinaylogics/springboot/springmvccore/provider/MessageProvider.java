package com.vinaylogics.springboot.springmvccore.provider;

import com.github.javafaker.Faker;
import com.vinaylogics.springboot.springmvccore.exceptions.NotFoundException;
import com.vinaylogics.springboot.springmvccore.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.LongStream;

@Component
public class MessageProvider {

    @Value("${spring.profiles.active}")
    private String profile;
    private Faker faker;
    private List<Message> messages;

    @PostConstruct
    private void initData(){
        faker = new Faker(Locale.forLanguageTag(profile));
        messages = new ArrayList<>();
        initializeMessage();
    }

    private void initializeMessage() {
        LongStream.rangeClosed(1,100).forEach(i->{
            messages.add(new Message(i, faker.funnyName().name(), faker.food().dish(), LocalDateTime.now()));
        });
    }

    public List<Message> findAll(){
        return messages;
    }

    public Optional<Message> findById(Long id){
        return messages.stream().filter(i-> i.getId().equals(id)).findAny();
    }

    public Message save(Message message){
        Long maxId = messages.stream().mapToLong(Message::getId).max().orElse(0)+1L;
        message.setId(maxId);
        message.setMessageTime(LocalDateTime.now());
        messages.add(message);
        return message;
    }

    public Message update(Long id, Message message){
        Message ref = messages.stream().filter(m-> m.getId().equals(id)).findAny().orElseThrow(() -> new NotFoundException("Message with id="+id+" Not Found"));
        message.setId(id);
        message.setMessageTime(LocalDateTime.now());
        messages.set(messages.indexOf(ref), message);
        return message;
    }

    public List<Message> pagingMessage(Integer size, Integer pageNumber, Long pageCount){
        int initialSize = pageNumber*size;
        int finalSize = initialSize+size;
        return messages.subList(initialSize,Math.min(finalSize,messages.size()));
    }

    public Long getMessageCount(){
        return Long.parseLong(String.valueOf(messages.size()));
    }

    public boolean deleteMessage(Long id){
        Message ref = messages.stream().filter(m-> m.getId().equals(id)).findAny().orElseThrow(() -> new NotFoundException("Message with id="+id+" Not Found"));
        messages.remove(ref);
        return true;
    }

    public boolean deleteMessage(Message message){
        Message ref = messages.stream().filter(m-> m.getId().equals(message.getId())).findAny().orElseThrow(() -> new NotFoundException("Message with id="+message.getId()+" Not Found"));
        messages.remove(ref);
        return true;
    }

}
