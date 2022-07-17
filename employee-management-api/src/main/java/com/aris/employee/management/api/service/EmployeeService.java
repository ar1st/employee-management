package com.aris.employee.management.api.service;

import com.aris.employee.management.api.dto.employee.GetEmployeeDTO;
import com.aris.employee.management.api.dto.employee.GetEmployeeWithAttributesDTO;
import com.aris.employee.management.api.mapper.EmployeeMapper;
import com.aris.employee.management.api.model.Attribute;
import com.aris.employee.management.api.model.Employee;
import com.aris.employee.management.api.repository.AttributeRepository;
import com.aris.employee.management.api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AttributeRepository attributeRepository;

    private final EmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    public List<GetEmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAllByOrderByIdAsc();

        return employeeMapper.map(employees);
    }

    @Transactional(readOnly = true)
    public GetEmployeeWithAttributesDTO getEmployee(Integer id) {
        Employee employee = findById(id);

        return employeeMapper.mapWithAttributes(employee);
    }

    private Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void createEmployee(String name, Date dateOfBirth, boolean hasCar, String xCoordinate,
                               String yCoordinate, List<Integer> attributesIds) {
        //todo validate attributes

        Employee employee = new Employee();

        fillEmployee(employee, name, dateOfBirth, hasCar, xCoordinate, yCoordinate, attributesIds);

        employeeRepository.save(employee);
    }

    private void fillEmployee(Employee employee, String name, Date dateOfBirth, boolean hasCar, String xCoordinate,
                              String yCoordinate, List<Integer> attributesIds) {
        employee.setName(name);
        employee.setDateOfBirth(dateOfBirth);
        employee.setCar(hasCar);
        employee.setXCoordinate(xCoordinate);
        employee.setYCoordinate(yCoordinate);

        List<Attribute> attributes = attributeRepository.findAllById(attributesIds);
        employee.setAttributes(new HashSet<>(attributes));
    }

    @Transactional
    public void editEmployee(Integer id, String name, Date dateOfBirth, boolean hasCar, String xCoordinate,
                             String yCoordinate, List<Integer> attributesIds) {

        Employee employee = findById(id);

        fillEmployee(employee, name, dateOfBirth, hasCar, xCoordinate, yCoordinate, attributesIds);

    }
}
