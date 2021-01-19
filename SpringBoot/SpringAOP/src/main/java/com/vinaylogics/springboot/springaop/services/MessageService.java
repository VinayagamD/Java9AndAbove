package com.vinaylogics.springboot.springaop.services;


import com.vinaylogics.springboot.springaop.dtos.MessageRequestDTO;
import com.vinaylogics.springboot.springaop.dtos.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    List<MessageResponseDTO> findAllMessage();

    MessageResponseDTO saveMessage(MessageRequestDTO message);

    MessageResponseDTO findById(Long id);
}
