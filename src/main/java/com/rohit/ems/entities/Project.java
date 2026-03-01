package com.rohit.ems.entities;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

}
