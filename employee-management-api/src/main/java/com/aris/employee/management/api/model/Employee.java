package com.aris.employee.management.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter @Setter @NoArgsConstructor
public class Employee {

    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date dateOfBirth;

    private boolean car;

    private String xCoordinate;

    private String yCoordinate;

    @ManyToMany(mappedBy = "employees")
    private Set<Attribute> attributes;

}
