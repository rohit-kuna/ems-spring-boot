package com.rohit.ems.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "passport")
@Data
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_number", nullable = false, unique = true)
    private Long passportNumber;

    @Column(name = "issuing_country", nullable = false)
    private String issuingCountry;

    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "date_of_expiry", nullable = false)
    private LocalDate dateOfExpiry;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_employee_id", referencedColumnName="id")
    private Employee employee;
}
