package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Patient;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> getByEmailAndPassword(String email, String pasword);
}
    