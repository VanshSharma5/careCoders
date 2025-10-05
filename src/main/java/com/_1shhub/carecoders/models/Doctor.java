package com._1shhub.carecoders.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String imageUrl;
    @Column(length = 32)
    private String name;
    @Column(unique = true)
    private String email;
    private Long lAddressId;
    private LocalDate dateOfBirth; // age an be calculate by this
    private String designation;
    private LocalDate dateOfJoin; // give the years in current add with prevExp give total experience
    private Integer previousExperience;
    private String department;
    private Long lHospitalId;
}