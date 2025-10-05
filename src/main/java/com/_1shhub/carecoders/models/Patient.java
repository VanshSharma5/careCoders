package com._1shhub.carecoders.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private String imageUrl;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    @Column(length = 16)
    private String phone;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<PatientRecord> records;
}