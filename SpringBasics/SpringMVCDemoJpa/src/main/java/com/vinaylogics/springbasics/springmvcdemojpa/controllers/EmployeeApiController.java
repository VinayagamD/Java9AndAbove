package com.vinaylogics.springbasics.springmvcdemojpa.controllers;

import com.vinaylogics.springbasics.springmvcdemojpa.models.Employee;
import com.vinaylogics.springbasics.springmvcdemojpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
