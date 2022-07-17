package com.aris.employee.management.api.dto.attribute;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
public class CreateAttributeDTO {

    @NotEmpty
    @Max(value = 50)
    private String name;

    @NotEmpty
    @Max(value = 50)
    private String value;
}
