package com.aris.employee.management.api.dto.attribute;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class EditAttributeDTO {

    @NotEmpty
    @Max(value = 50)
    private String value;
}
