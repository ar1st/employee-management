package com.aris.employee.management.api.service;

import com.aris.employee.management.api.dto.attribute.GetAttributeDTO;
import com.aris.employee.management.api.exception.AttributeExistsException;
import com.aris.employee.management.api.exception.EntityNotFoundException;
import com.aris.employee.management.api.mapper.AttributeMapper;
import com.aris.employee.management.api.model.Attribute;
import com.aris.employee.management.api.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    @Transactional(readOnly = true)
    public List<GetAttributeDTO> getAttributes() {
        List<Attribute> attributes = attributeRepository.findAllByOrderByIdAsc();

        return attributeMapper.map(attributes);
    }

    @Transactional
    public void createAttribute(String name, String value) {

        if (attributeRepository.existsByNameAndValue(name, value)) {
            throw new AttributeExistsException();
        }

        attributeRepository.save(new Attribute(name, value));
    }

    public GetAttributeDTO getAttribute(Integer id) {
        Attribute attribute = findById(id);

        return attributeMapper.map(attribute);
    }

    private Attribute findById(Integer id) {
        return attributeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void editAttribute(Integer id, String value) {
        Attribute attribute = findById(id);

        attribute.setValue(value);
    }

    @Transactional
    public void deleteAttribute(Integer id) {
        Attribute attribute = findById(id);

        attribute.removeEmployees();

        attributeRepository.deleteById(id);
    }
}
