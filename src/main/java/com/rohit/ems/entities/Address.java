package com.rohit.ems.entities;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_no", nullable = false)
    private Integer houseNo;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(name = "zip_code", nullable = false, length = 8)
    private String zipCode;

    @Enumerated(EnumType.STRING)
    @Column(name="address_type", nullable = false)
    private AddressType addressType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_employee_id", referencedColumnName = "id")
    private Employee employee;
}
