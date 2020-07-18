package com.vinaylogics.springbasics.aop.controllers;


import com.vinaylogics.springbasics.aop.models.Employee;
import com.vinaylogics.springbasics.aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/exception")
    public String  generateException(){
        throw new RuntimeException("Forced Exception");
    }
}
