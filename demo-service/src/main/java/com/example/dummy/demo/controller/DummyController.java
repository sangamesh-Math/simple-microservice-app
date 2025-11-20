package com.example.dummy.demo.controller;

import com.example.dummy.demo.dto.DepartmentDto;
import com.example.dummy.demo.service.DummyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {
    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dummyService.getDept(id));
    }
}
