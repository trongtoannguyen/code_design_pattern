package com.example.model_mapping.controller;

import com.example.model_mapping.entity.Employee;
import com.example.model_mapping.response.EmployeeResponse;
import com.example.model_mapping.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
        EmployeeResponse response = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/subemployees/{id}")
    private ResponseEntity<EmployeeResponse> subGetEmployeeDetails(@PathVariable("id") int id){
        EmployeeResponse response = employeeService.getEmployeeByIdUsingMapStruct(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
