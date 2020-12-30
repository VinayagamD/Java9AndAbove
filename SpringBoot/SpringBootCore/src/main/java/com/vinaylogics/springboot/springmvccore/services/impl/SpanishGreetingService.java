package com.vinaylogics.springboot.springmvccore.services.impl;

import com.vinaylogics.springboot.springmvccore.dtos.PagingMessageDTO;
import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("es")
@Service
public class SpanishGreetingService implements GreetingService {
    @Value("${message}")
    private String message;

    @Override
    public String greeting() {
        return message;
    }

    @Override
    public PagingMessageDTO<List<Message>> getPagingMessage(Integer size, Integer pageNumber, Long pageCount) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Message findById(Long id) {
        return null;
    }

    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public Message update(Long id, Message message) {
        return null;
    }

    @Override
    public void delete(Message message) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
