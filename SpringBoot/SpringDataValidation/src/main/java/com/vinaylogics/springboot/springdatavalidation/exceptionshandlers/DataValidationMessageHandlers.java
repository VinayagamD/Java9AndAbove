package com.vinaylogics.springboot.springdatavalidation.exceptionshandlers;

import com.vinaylogics.springboot.springdatavalidation.dto.ErrorDataDTO;
import com.vinaylogics.springboot.springdatavalidation.dto.ResponseDataDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DataValidationMessageHandlers extends ResponseEntityExceptionHandler {


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ResponseDataDTO<Object>> handleGenericException(Exception exception){
        return ResponseEntity.badRequest().body(
                ResponseDataDTO.builder()
                        .success(false)
                        .error(ErrorDataDTO.builder()
                                .message("Unknown Error")
                                .messages(List.of(exception.getMessage()))
                                .build()
                        )
                        .message("Failed")
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDataDTO.builder()
                .success(false)
                .error(ErrorDataDTO.builder()
                        .message("ValidationError")
                        .validationError(true)
                        .messages(ex.getBindingResult().getAllErrors().stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.toList()))
                        .keys(ex.getBindingResult().getAllErrors().stream()
                                .map((error) -> ((FieldError) error).getField()).collect(Collectors.toList()))
                        .build())
                .message("Failed")
                .build());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(ResponseDataDTO.builder()
                .success(false)
                .error(ErrorDataDTO.builder()
                        .message("Required Input is missing")
                        .messages(List.of("Input is improper"))
                        .build())

                .message("Failed")
                .build());
    }
}
