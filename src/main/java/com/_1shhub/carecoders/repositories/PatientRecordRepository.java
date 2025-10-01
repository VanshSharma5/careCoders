package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.PatientRecord;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
}