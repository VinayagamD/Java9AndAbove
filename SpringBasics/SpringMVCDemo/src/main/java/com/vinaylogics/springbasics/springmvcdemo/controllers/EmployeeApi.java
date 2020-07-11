package com.vinaylogics.springbasics.springmvcdemo.controllers;

import com.vinaylogics.springbasics.springmvcdemo.models.Employee;
import com.vinaylogics.springbasics.springmvcdemo.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {

    private final EmployeeService service;

    public EmployeeApi(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public @ResponseBody Employee getEmployee(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping()
    public @ResponseBody boolean saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

}
