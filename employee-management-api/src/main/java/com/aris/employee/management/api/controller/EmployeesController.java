package com.aris.employee.management.api.controller;

import com.aris.employee.management.api.dto.EmptyResponseDTO;
import com.aris.employee.management.api.dto.employee.CreateEmployeeDTO;
import com.aris.employee.management.api.dto.employee.EditEmployeeDTO;
import com.aris.employee.management.api.dto.employee.GetEmployeeDTO;
import com.aris.employee.management.api.dto.employee.GetEmployeeWithAttributesDTO;
import com.aris.employee.management.api.rest.ApiResponse;
import com.aris.employee.management.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetEmployeeDTO>>> getEmployees(@RequestParam(required = false) Integer attributeId) {

        List<GetEmployeeDTO> employees;
        if (attributeId == null) {
            employees = employeeService.getEmployees();
        } else {
            employees = employeeService.getEmployeesByAttributeId(attributeId);
        }

        return ResponseEntity.ok(new ApiResponse<>(employees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetEmployeeWithAttributesDTO>> getEmployee(@PathVariable Integer id) {
        GetEmployeeWithAttributesDTO employee = employeeService.getEmployee(id);

        return ResponseEntity.ok(new ApiResponse<>(employee));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmptyResponseDTO>> createEmployee(@RequestBody CreateEmployeeDTO request) {
        employeeService.createEmployee(request.getName(), request.getDateOfBirth(), request.isCar(),
                request.getXCoordinate(), request.getYCoordinate(), request.getAttributes());

        return ResponseEntity.ok(new ApiResponse<>());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmptyResponseDTO>> editEmployee(@PathVariable Integer id,
                                                                      @RequestBody @Valid EditEmployeeDTO request) {
        employeeService.editEmployee(id, request.getName(), request.getDateOfBirth(), request.isCar(),
                request.getXCoordinate(), request.getYCoordinate(), request.getAttributes());

        return ResponseEntity.ok(new ApiResponse<>());
    }
}
