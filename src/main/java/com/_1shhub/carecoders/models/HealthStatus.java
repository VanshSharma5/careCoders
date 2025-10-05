package com._1shhub.carecoders.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long healthStatusId;
    @Column(length = 7)
    private String bloodPressure;
    private Float bloodSugar;
    private Float weight;
    private String symptoms;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;
}
