package com.vinaylogics.springboot.springdatavalidation.controllers;

import com.vinaylogics.springboot.springdatavalidation.dto.MessageRequestDTO;
import com.vinaylogics.springboot.springdatavalidation.dto.MessageResponseDTO;
import com.vinaylogics.springboot.springdatavalidation.dto.ResponseDataDTO;
import com.vinaylogics.springboot.springdatavalidation.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public ResponseEntity<ResponseDataDTO<MessageResponseDTO>> saveMessage(@RequestBody @Valid MessageRequestDTO message){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDataDTO.<MessageResponseDTO>builder()
                .data(service.saveMessage(message))
                        .message("Message Creation Successful")
                        .success(true)
                        .build());
    }

}
