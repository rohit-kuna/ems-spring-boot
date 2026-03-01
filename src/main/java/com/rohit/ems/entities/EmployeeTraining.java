package com.rohit.ems.entities;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_training_lookup")
public class EmployeeTraining {

    @EmbeddedId
    private EmployeeTrainingId employeeTrainingId;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name="fk_employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("trainingId")
    @JoinColumn(name="fk_training_id")
    private Training training;

    @JoinColumn(name="start_date")
    private LocalDate startDate;

    @JoinColumn(name="end_date")
    private LocalDate endDate;
}


