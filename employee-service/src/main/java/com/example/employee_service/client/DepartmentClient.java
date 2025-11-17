package com.example.employee_service.client;

import com.example.employee_service.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DepartmentClient {

    private final RestTemplate restTemplate;
//    @Value("${department.service.url}")
//    private String baseUrl;

    public DepartmentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DepartmentDto getDepartment(Long id) {
//        String url = baseUrl + "/api/departments/" + id;
        String url = "http://DEPARTMENT-SERVICE/api/departments/" + id;
        System.out.println("Printing url: " + url);
        return restTemplate.getForObject(url, DepartmentDto.class);
    }

}

