package com.aris.employee.management.api.dto.employee;

import com.aris.employee.management.api.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class GetEmployeeWithAttributesDTO {

    private Integer id;

    private String name;

    private Date dateOfBirth;

    private boolean car;

    private String xCoordinate;

    private String yCoordinate;

    private List<Integer> attributes;
}
