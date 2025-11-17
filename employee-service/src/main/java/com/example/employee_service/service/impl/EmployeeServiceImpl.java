package com.example.employee_service.service.impl;

import com.example.employee_service.client.DepartmentClient;
import com.example.employee_service.dto.DepartmentDto;
import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.dto.EmployeeWithDepartmentDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.exception.NotFoundException;
import com.example.employee_service.mapper.EmployeeMapper;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;
    private final DepartmentClient departmentClient;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repo, DepartmentClient departmentClient, EmployeeMapper mapper) {
        this.repo = repo;
        this.departmentClient = departmentClient;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Override
    public EmployeeWithDepartmentDto getEmployee(Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id " + id));

        DepartmentDto dept = departmentClient.getDepartment(emp.getDepartmentId());
        return new EmployeeWithDepartmentDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), dept);
    }
}
