package com.vinaylogics.springboot.springemail.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String senderEmail;
    private String subject;
    private String message;
}
