package com._1shhub.carecoders.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private int age;
    private String gender;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private Date dateOfRegistration;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<PatientRecord> records;

    @OneToMany(mappedBy = "patient")
    private List<Report> reports;

    @OneToMany(mappedBy = "patient")
    private List<HealthStatus> healthStatuses;
}