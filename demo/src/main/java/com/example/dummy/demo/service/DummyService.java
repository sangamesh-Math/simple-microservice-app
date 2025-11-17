package com.example.dummy.demo.service;

import com.example.dummy.demo.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DummyService {

    private final WebClient.Builder webClient;
    private final String departmentServiceUrl;

    public DummyService(WebClient.Builder webClient,
                        @Value("${department.service.url}") String departmentServiceUrl) {
        this.webClient = webClient;
        this.departmentServiceUrl = departmentServiceUrl;
    }

    public DepartmentDto getDept(Long id) {
        return webClient.build()
                .get()
                .uri(departmentServiceUrl + "/" + id)
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
    }
}
