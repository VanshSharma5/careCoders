package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
    