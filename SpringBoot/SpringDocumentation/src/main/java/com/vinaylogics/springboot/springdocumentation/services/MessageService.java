package com.vinaylogics.springboot.springdocumentation.services;




import com.vinaylogics.springboot.springdocumentation.dtos.MessageRequestDTO;
import com.vinaylogics.springboot.springdocumentation.dtos.MessageResponseDTO;

import java.util.List;

public interface MessageService {

    List<MessageResponseDTO> findAllMessage();

    MessageResponseDTO saveMessage(MessageRequestDTO message);

    MessageResponseDTO findById(Long id);
}
