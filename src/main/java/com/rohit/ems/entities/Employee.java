package com.rohit.ems.entities;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="salary", nullable = true)
    private Long salary;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_department_id", referencedColumnName="id")
    private Department department;

    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
    private Passport passport;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="employee_project",
        joinColumns = @JoinColumn(name="fk_employee_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="fk_project_id", referencedColumnName = "id")
    )
    private Set<Project> projects= new HashSet<>();

}
