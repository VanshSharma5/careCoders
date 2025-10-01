package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.HealthStatus;

public interface HealthStatusRepository extends JpaRepository<HealthStatus, Long> {
}