package com.vinaylogics.springboot.springweb.handlers;

import com.vinaylogics.springboot.springweb.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundData(HttpServletRequest request, NotFoundException exception){
        log.info("Message Not Found", exception);
        ModelAndView modelAndView = new ModelAndView("errors/data_not_found.html");
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

}
