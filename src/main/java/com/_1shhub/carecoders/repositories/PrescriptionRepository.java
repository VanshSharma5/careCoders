package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}