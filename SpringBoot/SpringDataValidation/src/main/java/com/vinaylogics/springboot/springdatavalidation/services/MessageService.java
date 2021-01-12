package com.vinaylogics.springboot.springdatavalidation.services;

import com.vinaylogics.springboot.springdatavalidation.dto.MessageRequestDTO;
import com.vinaylogics.springboot.springdatavalidation.dto.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    List<MessageResponseDTO> findAllMessage();

    MessageResponseDTO saveMessage(MessageRequestDTO message);
}
