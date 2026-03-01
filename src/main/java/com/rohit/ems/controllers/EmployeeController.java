package com.rohit.ems.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @PostMapping()
    public String createEmployee() {
        return "Employee created successfully!";
    }
}
