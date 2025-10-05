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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String imageUrl;
    private String name;
    private String gender;
    private String password;
    private LocalDate dateOfBirth;
    @Column(length = 16)
    private String phone;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfRegistration;

    private Long lAddressId;
}