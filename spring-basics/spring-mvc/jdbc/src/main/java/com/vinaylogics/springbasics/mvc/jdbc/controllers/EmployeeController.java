package com.vinaylogics.springbasics.mvc.jdbc.controllers;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;
import com.vinaylogics.springbasics.mvc.jdbc.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ModelAndView getAllEmployee(){
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", service.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleEmployee(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("employees-detail");
        modelAndView.addObject("employee", service.findById(id));
        return modelAndView;
    }

    @GetMapping("/testqueryparam")
    public ModelAndView testQueryParam(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("testqueryparam");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAddEmployeeView(){
        ModelAndView modelAndView = new ModelAndView("add-employees");
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
}
