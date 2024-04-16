package com.example.model_mapping.mapper;

import com.example.model_mapping.entity.Employee;
import com.example.model_mapping.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "country", target = "nationality")
    @Mapping(source = "department", target = "nameOfDepartment")
    EmployeeResponse employeeToEmployeeResponse(Employee employee);

    @Mapping(source = "nationality", target = "country")
    @Mapping(source = "nameOfDepartment", target = "department")
    Employee employeeResponseToEmployee(EmployeeResponse employeeResponse);
}
