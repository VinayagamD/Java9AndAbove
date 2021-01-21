package com.vinaylogics.springboot.springdocumentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDTO {

    private String name;
    private String message;
}
