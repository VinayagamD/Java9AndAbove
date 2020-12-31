package com.vinaylogics.springboot.springmvccore.services.impl;

import com.vinaylogics.springboot.springmvccore.dtos.PagingMessageDTO;
import com.vinaylogics.springboot.springmvccore.exceptions.NotFoundException;
import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.provider.MessageProvider;
import com.vinaylogics.springboot.springmvccore.services.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Profile({"en","default"})
public class EnglishGreetingService implements GreetingService {

    private final MessageProvider provider;

    @Value("${message}")
    private String message;

    public EnglishGreetingService(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public String greeting() {
        return message;
    }

    @Override
    public PagingMessageDTO<List<Message>> getPagingMessage(Integer size, Integer pageNumber, Long pageCount) {
        return new PagingMessageDTO<>(size, pageNumber+1, provider.getMessageCount(), provider.pagingMessage(size, pageNumber, pageCount));
    }

    @Override
    public List<Message> findAll() {
        return provider.findAll();
    }

    @Override
    public Message findById(Long id) {
        return provider.findById(id).orElseThrow(()-> new NotFoundException("Message With Id="+id+" not found"));
    }

    @Override
    public Message save(Message message) {
        return provider.save(message);
    }

    @Override
    public Message update(Long id, Message message) {
        return provider.update(id,message);
    }

    @Override
    public void delete(Message message) {
        provider.deleteMessage(message);
    }

    @Override
    public void deleteById(Long id) {
        provider.deleteMessage(id);
    }
}
