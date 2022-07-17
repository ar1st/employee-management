package com.aris.employee.management.api.dto.attribute;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class EditAttributeDTO {

    @NotEmpty
    @Size(max = 50)
    private String value;
}
