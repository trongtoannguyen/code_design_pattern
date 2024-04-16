package com.example.model_mapping.service;

import com.example.model_mapping.response.EmployeeResponse;

public interface IEmployeeService {
    EmployeeResponse getEmployeeById(int id);

    // getEmployeeById implement MapStruct lib
    EmployeeResponse getEmployeeByIdUsingMapStruct(int id);
}
