package com.example.demo.controller;

import com.example.demo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees")
    public String index() {
        return "employee";
    }

    @GetMapping("/")
    public String home() {
        return "employee";
    }
}
