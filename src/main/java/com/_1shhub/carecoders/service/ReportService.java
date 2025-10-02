package com._1shhub.carecoders.service;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.dto.report.ReportDetailDTO;
import com._1shhub.carecoders.models.PatientRecord;
import com._1shhub.carecoders.models.Report;
import com._1shhub.carecoders.repositories.PatientRecordRepository;
import com._1shhub.carecoders.repositories.ReportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final PatientRecordRepository recordRepository;

    public ReportDetailDTO getById(Long id) {
        Report r = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        return new ReportDetailDTO(
                r.getReportId(),
                r.getReport(),
                r.getDateOfSample(),
                r.getDateOfReport(),
                r.getFileName(),
                r.getFileType(),
                "/api/reports/" + r.getReportId() + "/download",
                new DoctorSummaryDTO(r.getDoctor().getDoctorId(), r.getDoctor().getName(), r.getDoctor().getDesignation())
        );
    }

    public ReportDetailDTO attachFile(Long recordId, String fileName, String fileType, String filePath) {
        PatientRecord record = recordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        Report r = record.getReport();
        if (r == null) {
            r = new Report();
            r.setReport("Uploaded report file");
            r.setPatient(record.getPatient());
            r.setDoctor(record.getDoctor());
        }

        r.setFileName(fileName);
        r.setFileType(fileType);
        r.setFilePath(filePath);

        reportRepository.save(r);
        record.setReport(r);
        recordRepository.save(record);

        return getById(r.getReportId());
    }
}


