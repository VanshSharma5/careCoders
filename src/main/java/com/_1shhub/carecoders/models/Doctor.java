package com._1shhub.carecoders.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private int age;
    private String designation;
    private Date dateOfJoin;
    private String department;
    private int experience;

    @OneToMany(mappedBy = "doctor")
    private List<PatientRecord> records;

    @OneToMany(mappedBy = "doctor")
    private List<Report> reports;
}
