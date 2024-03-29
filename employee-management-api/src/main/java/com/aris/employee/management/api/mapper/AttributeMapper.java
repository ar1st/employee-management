package com.aris.employee.management.api.mapper;

import com.aris.employee.management.api.dto.attribute.GetAttributeDTO;
import com.aris.employee.management.api.model.Attribute;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AttributeMapper {

    GetAttributeDTO map(Attribute attribute);

    List<GetAttributeDTO> map(List<Attribute> attributes);
}
