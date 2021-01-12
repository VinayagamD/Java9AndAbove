package com.vinaylogics.springboot.springdatamongo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    @Id
    private String id;
    private String name;
    private String message;
    @Builder.Default
    private LocalDateTime messageTime = LocalDateTime.now();

}
