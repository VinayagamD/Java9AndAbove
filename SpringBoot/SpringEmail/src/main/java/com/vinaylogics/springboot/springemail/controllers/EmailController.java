package com.vinaylogics.springboot.springemail.controllers;

import com.vinaylogics.springboot.springemail.dtos.EmailDTO;
import com.vinaylogics.springboot.springemail.dtos.ResponseDataDTO;
import com.vinaylogics.springboot.springemail.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping
    public ResponseEntity<ResponseDataDTO<Boolean>> sendEmail(@RequestBody EmailDTO email){
        return ResponseEntity.ok(ResponseDataDTO.<Boolean>builder()
                .message("Email sent successful")
                .success(true)
                .data(service.sendEmail(email))
                .build());
    }
}
