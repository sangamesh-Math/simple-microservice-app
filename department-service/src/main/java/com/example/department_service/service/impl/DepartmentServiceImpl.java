package com.example.department_service.service.impl;

import com.example.department_service.dto.DepartmentDto;
import com.example.department_service.entity.Department;
import com.example.department_service.exception.NotFoundException;
import com.example.department_service.mapper.DepartmentMapper;
import com.example.department_service.repository.DepartmentRepository;
import com.example.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repo;
    private final DepartmentMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository repo, DepartmentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto dto) {
        Department dept = mapper.toEntity(dto);
        Department saved = repo.save(dept);
        return mapper.toDto(saved);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department dept = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Department not found with id " + id));
        return mapper.toDto(dept);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department dept = repo.findByCode(code);
        DepartmentDto deptdto = mapper.toDto(dept);
        return deptdto;
    }
}