package com.example.department_service.mapper;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto toDto(Department entity);
    Department toEntity(DepartmentDto dto);
}
