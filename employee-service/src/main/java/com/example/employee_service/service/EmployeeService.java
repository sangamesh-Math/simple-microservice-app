package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.dto.EmployeeWithDepartmentDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto dto);
    EmployeeWithDepartmentDto getEmployee(Long id);
}
