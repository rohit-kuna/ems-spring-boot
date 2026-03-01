package com.rohit.ems.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;


@Entity
@Table(name="training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="active", nullable = false)
    private Boolean active = true;

    @Column(name="domain")
    private String domain;

}
