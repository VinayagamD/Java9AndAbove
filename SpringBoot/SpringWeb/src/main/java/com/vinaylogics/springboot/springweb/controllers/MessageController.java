package com.vinaylogics.springboot.springweb.controllers;

import com.vinaylogics.springboot.springweb.dto.MessageResponseDTO;
import com.vinaylogics.springboot.springweb.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService service;

    @GetMapping
    public ModelAndView getAllMessages(){
        ModelAndView modelAndView = new ModelAndView("messages/all");
        List<MessageResponseDTO> messages = service.findAllMessage();
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getMessage(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("messages/details");
        MessageResponseDTO message = service.findById(id);
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
