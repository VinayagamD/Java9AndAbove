package com.vinaylogics.springboot.springmvc.controllers;

import com.vinaylogics.springboot.springmvc.models.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ModelAndView getMessage(){
        ModelAndView modelAndView = new ModelAndView("hello");
        HelloModel helloModel = new HelloModel();
        helloModel.setMessage("Hi Anand. Welcome To Spring Controller");
        modelAndView.addObject("hello", helloModel);
        return modelAndView;
    }

}
