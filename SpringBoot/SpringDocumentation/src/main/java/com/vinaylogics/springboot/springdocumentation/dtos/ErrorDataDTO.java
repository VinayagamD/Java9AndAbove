package com.vinaylogics.springboot.springdocumentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDataDTO implements Serializable {

    private List<String> messages;
    private String message;
    private List<String> keys;
    private boolean validationError;

}
