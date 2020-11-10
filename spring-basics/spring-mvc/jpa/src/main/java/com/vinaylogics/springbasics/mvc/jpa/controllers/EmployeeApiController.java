package com.vinaylogics.springbasics.mvc.jpa.controllers;


import com.vinaylogics.springbasics.mvc.jpa.models.Employee;
import com.vinaylogics.springbasics.mvc.jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public @ResponseBody List<Employee> getAll(){
        return service.findAll();
    }

    @GetMapping( "mydata")
    public ResponseEntity<String> demoData() throws Exception {
      throw new Exception("Forced Exception");
    }
}
