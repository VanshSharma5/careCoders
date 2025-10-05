package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}