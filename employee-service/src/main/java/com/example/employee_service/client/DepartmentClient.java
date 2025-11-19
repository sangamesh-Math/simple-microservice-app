package com.example.employee_service.client;

import com.example.employee_service.dto.DepartmentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DepartmentClient {

    private final RestTemplate restTemplate;
    public DepartmentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DepartmentDto getDepartment(Long id) {
        String url = "http://DEPARTMENT-SERVICE/api/departments/" + id;
        System.out.println("Printing url: " + url);
        return restTemplate.getForObject(url, DepartmentDto.class);
    }

}

