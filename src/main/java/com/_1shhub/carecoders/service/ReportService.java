package com._1shhub.carecoders.service;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.dto.report.ReportDetailDTO;
import com._1shhub.carecoders.dto.report.ReportSummaryDTO;
import com._1shhub.carecoders.models.Report;
import com._1shhub.carecoders.repositories.ReportRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<ReportSummaryDTO> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(r -> new ReportSummaryDTO(r.getReportId(), r.getReport()))
                .collect(Collectors.toList());
    }

    public ReportDetailDTO getReportById(Long id) {
        Report r = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        return new ReportDetailDTO(
                r.getReportId(),
                r.getReport(),
                r.getDateOfSample(),
                r.getDateOfReport(),
                new DoctorSummaryDTO(r.getDoctor().getDoctorId(), r.getDoctor().getName(), r.getDoctor().getDesignation())
        );
    }
}

