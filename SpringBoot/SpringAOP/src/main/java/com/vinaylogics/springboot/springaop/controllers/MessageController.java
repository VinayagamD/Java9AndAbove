package com.vinaylogics.springboot.springaop.controllers;


import com.vinaylogics.springboot.springaop.dtos.MessageRequestDTO;
import com.vinaylogics.springboot.springaop.dtos.MessageResponseDTO;
import com.vinaylogics.springboot.springaop.dtos.ResponseDataDTO;
import com.vinaylogics.springboot.springaop.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public ResponseEntity<ResponseDataDTO<MessageResponseDTO>> saveMessage(@RequestBody MessageRequestDTO message){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDataDTO.<MessageResponseDTO>builder()
                .data(service.saveMessage(message))
                        .message("Message Creation Successful")
                        .success(true)
                        .build());
    }

    @GetMapping
    public ResponseEntity<ResponseDataDTO<List<MessageResponseDTO>>> findAll(){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDataDTO.<List<MessageResponseDTO>>builder()
                        .data(service.findAllMessage())
                        .message("Message Creation Successful")
                        .success(true)
                        .build());
    }

    @GetMapping({"{id}"})
    public ResponseEntity<ResponseDataDTO<MessageResponseDTO>> findMessage(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDataDTO.<MessageResponseDTO>builder()
                        .data(service.findById(id))
                        .message("Message Creation Successful")
                        .success(true)
                        .build());
    }

}
