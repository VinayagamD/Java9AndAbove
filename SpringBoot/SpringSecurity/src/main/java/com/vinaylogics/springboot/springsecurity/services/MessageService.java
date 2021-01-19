package com.vinaylogics.springboot.springsecurity.services;



import com.vinaylogics.springboot.springsecurity.dtos.MessageRequestDTO;
import com.vinaylogics.springboot.springsecurity.dtos.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    List<MessageResponseDTO> findAllMessage();

    MessageResponseDTO saveMessage(MessageRequestDTO message);

    MessageResponseDTO findById(Long id);
}
