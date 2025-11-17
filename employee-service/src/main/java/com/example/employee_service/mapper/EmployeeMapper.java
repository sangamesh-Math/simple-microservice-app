package com.example.employee_service.mapper;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee entity);
    Employee toEntity(EmployeeDto dto);
}
