package com.vinaylogics.springbasics.springmvcdemojpa.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;

@RestControllerAdvice
public class ApiExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String  handleException(Exception exception){
        logger.debug(exception.getMessage());
        return "Unknown Error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ServletException.class)
    public @ResponseBody  String handle404() {
        return "Please Other url this url not found";
    }
}
