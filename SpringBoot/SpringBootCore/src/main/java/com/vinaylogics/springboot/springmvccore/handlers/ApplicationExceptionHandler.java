package com.vinaylogics.springboot.springmvccore.handlers;

import com.vinaylogics.springboot.springmvccore.dtos.ResponseDataDTO;
import com.vinaylogics.springboot.springmvccore.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDataDTO<?>> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDataDTO.Builder<>()
                        .success(false)
                        .message(exception.getMessage())
                        .build());
    }
}
