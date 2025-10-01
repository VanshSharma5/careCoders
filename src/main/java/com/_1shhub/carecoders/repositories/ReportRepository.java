package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}