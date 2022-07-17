package com.aris.employee.management.api.repository;

import com.aris.employee.management.api.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

    boolean existsByNameAndValue(String name, String value);

    List<Attribute> findAllByOrderByIdAsc();
}
