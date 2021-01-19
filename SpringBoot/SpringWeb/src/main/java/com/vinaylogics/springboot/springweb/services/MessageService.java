package com.vinaylogics.springboot.springweb.services;

import com.vinaylogics.springboot.springweb.dto.MessageRequestDTO;
import com.vinaylogics.springboot.springweb.dto.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    List<MessageResponseDTO> findAllMessage();

    MessageResponseDTO saveMessage(MessageRequestDTO message);

    MessageResponseDTO findById(Long id);
}
