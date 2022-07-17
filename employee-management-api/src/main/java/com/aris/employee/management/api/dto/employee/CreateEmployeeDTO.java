package com.aris.employee.management.api.dto.employee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Setter @Getter
public class CreateEmployeeDTO {

    @NotEmpty
    @Size(max = 50)
    private String name;

    @NotNull
    private Date dateOfBirth;

    private boolean car;

    @NotEmpty
    @Size(max = 50)
    private String xCoordinate;

    @NotEmpty
    @Size(max = 50)
    private String yCoordinate;

    private List<Integer> attributes;

}
