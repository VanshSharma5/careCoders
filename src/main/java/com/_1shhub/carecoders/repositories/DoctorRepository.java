package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}