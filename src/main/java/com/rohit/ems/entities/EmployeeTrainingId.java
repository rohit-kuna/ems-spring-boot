package com.rohit.ems.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode
public class EmployeeTrainingId implements Serializable {

    @Column(name="fk_employee_id")
    private Long employeeId;

    @Column(name="fk_training_id")
    private Long trainingId;

}
