package com.rohit.ems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.ems.dto.EmployeeResult;
import com.rohit.ems.mappers.EmployeeMapper;
import com.rohit.ems.repositories.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping()
    public List<EmployeeResult> createEmployee() {
        return employeeMapper.mapEntityToResultList(employeeRepository.findAll());
    }
}
