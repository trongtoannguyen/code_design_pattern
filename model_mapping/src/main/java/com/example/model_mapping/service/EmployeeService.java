package com.example.model_mapping.service;

import com.example.model_mapping.entity.Employee;
import com.example.model_mapping.mapper.EmployeeMapper;
import com.example.model_mapping.repository.EmployeeRepo;
import com.example.model_mapping.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponse getEmployeeById(int id) {
        EmployeeResponse employeeResponse = null;
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        }
        return employeeResponse;
    }

    @Override
    public EmployeeResponse getEmployeeByIdUsingMapStruct(int id) {
        EmployeeResponse employeeResponse = null;
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employeeResponse = EmployeeMapper.INSTANCE.employeeToEmployeeResponse(employee.get());
        }
        return employeeResponse;
    }
}
