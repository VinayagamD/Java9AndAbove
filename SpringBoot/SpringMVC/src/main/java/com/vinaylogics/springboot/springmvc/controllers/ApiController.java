package com.vinaylogics.springboot.springmvc.controllers;

import com.vinaylogics.springboot.springmvc.models.HelloModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class ApiController {

    @GetMapping
    public ResponseEntity<HelloModel> getMessage(){
        HelloModel helloModel = new HelloModel();
        helloModel.setMessage("Hi Anand. Welcome To Spring Controller");
        return ResponseEntity.ok(helloModel);
    }
}
