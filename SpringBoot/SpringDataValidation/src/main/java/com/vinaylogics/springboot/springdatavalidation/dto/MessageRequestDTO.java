package com.vinaylogics.springboot.springdatavalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDTO {


    @NotEmpty(message = "name is Required")
    private String name;
    @NotEmpty(message = "message is Required")
    private String message;
}
