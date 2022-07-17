package com.aris.employee.management.api.service;

import com.aris.employee.management.api.dto.employee.GetEmployeeDTO;
import com.aris.employee.management.api.mapper.EmployeeMapper;
import com.aris.employee.management.api.model.Employee;
import com.aris.employee.management.api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public List<GetEmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employeeMapper.map(employees);
    }
}
