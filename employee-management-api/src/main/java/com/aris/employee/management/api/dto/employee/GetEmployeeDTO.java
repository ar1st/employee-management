package com.aris.employee.management.api.dto.employee;

import com.aris.employee.management.api.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class GetEmployeeDTO {

    private Integer id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Employee.DATE_TIME_FORMAT)
    private Date dateOfBirth;

    private boolean car;

    private String xCoordinate;

    private String yCoordinate;

}
