package com.vinaylogics.springboot.springdatavalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
