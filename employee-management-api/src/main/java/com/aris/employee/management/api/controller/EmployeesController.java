package com.aris.employee.management.api.controller;

import com.aris.employee.management.api.dto.employee.GetEmployeeDTO;
import com.aris.employee.management.api.rest.ApiResponse;
import com.aris.employee.management.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetEmployeeDTO>>> getEmployees() {
        List<GetEmployeeDTO> employees = employeeService.getEmployees();

        return ResponseEntity.ok(new ApiResponse<>(employees));
    }
}
