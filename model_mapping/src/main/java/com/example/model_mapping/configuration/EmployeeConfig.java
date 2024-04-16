package com.example.model_mapping.configuration;

import com.example.model_mapping.entity.Employee;
import com.example.model_mapping.repository.EmployeeRepo;
import com.example.model_mapping.response.EmployeeResponse;
import com.example.model_mapping.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public EmployeeService employeeBean(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        return new EmployeeService(employeeRepo, modelMapper);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Handling Mismatched Types with validation
        try {
            modelMapper.typeMap(Employee.class, EmployeeResponse.class).addMappings(mapper -> {
                mapper.map(Employee::getCountry, EmployeeResponse::setNationality);
                mapper.map(Employee::getDepartment, EmployeeResponse::setNameOfDepartment);

                // Skip the id field
                mapper.skip(EmployeeResponse::setId);
            });
            modelMapper.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelMapper;
    }
}
