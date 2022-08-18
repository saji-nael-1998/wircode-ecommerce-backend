package com.wircodeteam.ecommercedemo.controller;

import com.wircodeteam.ecommercedemo.model.Employee;
import com.wircodeteam.ecommercedemo.requests.AuthRequest;
import com.wircodeteam.ecommercedemo.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public String create(@RequestBody AuthRequest authRequest){
        return "true";
    }
}
