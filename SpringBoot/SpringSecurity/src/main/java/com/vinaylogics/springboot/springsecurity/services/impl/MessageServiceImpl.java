package com.vinaylogics.springboot.springsecurity.services.impl;

import com.vinaylogics.springboot.springsecurity.dtos.MessageRequestDTO;
import com.vinaylogics.springboot.springsecurity.dtos.MessageResponseDTO;
import com.vinaylogics.springboot.springsecurity.exceptions.NotFoundException;
import com.vinaylogics.springboot.springsecurity.models.Message;
import com.vinaylogics.springboot.springsecurity.repositories.MessageRepository;
import com.vinaylogics.springboot.springsecurity.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    @Override
    public List<MessageResponseDTO> findAllMessage() {
        return repository.findAll().stream().map(data-> MessageResponseDTO.builder()
                .id(data.getId())
                .messageTime(data.getMessageTime())
                .name(data.getName())
                .message(data.getMessage())
                .build()).collect(Collectors.toList());
    }

    @Override
    public MessageResponseDTO saveMessage(MessageRequestDTO request) {
        Message message = new Message();
        message.setMessage(request.getMessage());
        message.setName(request.getName());
        message = repository.save(message);
        return MessageResponseDTO.builder()
                .id(message.getId())
                .name(message.getName())
                .message(message.getMessage())
                .messageTime(message.getMessageTime())
                .build();
    }

    @Override
    public MessageResponseDTO findById(Long id) {
        Message message = repository.findById(id).orElseThrow(()-> new NotFoundException("Message with id "+id+" not found"));
        return MessageResponseDTO.builder()
                .id(message.getId())
                .name(message.getName())
                .message(message.getMessage())
                .messageTime(message.getMessageTime())
                .build();
    }
}
