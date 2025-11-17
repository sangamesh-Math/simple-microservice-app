package com.example.employee_service.controller;

import com.example.employee_service.dto.EmployeeDto;
import com.example.employee_service.dto.EmployeeWithDepartmentDto;
import com.example.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeWithDepartmentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployee(id));
    }
}
