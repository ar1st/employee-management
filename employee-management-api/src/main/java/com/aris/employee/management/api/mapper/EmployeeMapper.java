package com.aris.employee.management.api.mapper;

import com.aris.employee.management.api.dto.employee.GetEmployeeDTO;
import com.aris.employee.management.api.dto.employee.GetEmployeeWithAttributesDTO;
import com.aris.employee.management.api.model.Attribute;
import com.aris.employee.management.api.model.Employee;
import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    GetEmployeeWithAttributesDTO mapWithAttributes(Employee employee);

    default Integer mapAttribute(Attribute attribute) {
        return attribute.getId();
    }

    GetEmployeeDTO map(Employee attribute);

    List<GetEmployeeDTO> map(List<Employee> attributes);
}
