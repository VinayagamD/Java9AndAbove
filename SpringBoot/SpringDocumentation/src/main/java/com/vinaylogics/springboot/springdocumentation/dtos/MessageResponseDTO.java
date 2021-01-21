package com.vinaylogics.springboot.springdocumentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponseDTO {

    private Long id;
    private String name;
    private String message;
    private LocalDateTime messageTime;

}
