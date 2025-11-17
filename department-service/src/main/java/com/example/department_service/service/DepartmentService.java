package com.example.department_service.service;

import com.example.department_service.dto.DepartmentDto;

import java.util.Optional;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto dto);
    DepartmentDto getDepartmentById(Long id);

    DepartmentDto getDepartmentByCode(String code);
}
