package com.vinaylogics.springboot.springdatavalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDataDTO<T> implements Serializable {

    private boolean success;
    private String message;
    private ErrorDataDTO error;
    private T data;
}
