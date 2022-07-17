package com.aris.employee.management.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attributes")
@Getter @Setter @NoArgsConstructor
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String value;

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @ManyToMany
    @JoinTable(
            name="attributes_employees"
            , joinColumns={
            @JoinColumn(name="attribute_id")
    }
            , inverseJoinColumns={
            @JoinColumn(name="user_id")
    }
    )
    private Set<Employee> employees;
}
