package com.aris.employee.management.api.repository;

import com.aris.employee.management.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByIdAsc();

    List<Employee> findAllByAttributesId(Integer id);
}
