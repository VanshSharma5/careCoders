package com._1shhub.carecoders.service;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.dto.prescription.PrescriptionDTO;
import com._1shhub.carecoders.dto.record.PatientRecordDetailDTO;
import com._1shhub.carecoders.dto.record.PatientRecordSummaryDTO;
import com._1shhub.carecoders.dto.report.ReportSummaryDTO;
import com._1shhub.carecoders.models.PatientRecord;
import com._1shhub.carecoders.repositories.PatientRecordRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientRecordService {
    private final PatientRecordRepository recordRepository;

    public PatientRecordService(PatientRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<PatientRecordSummaryDTO> getAllRecords() {
        return recordRepository.findAll()
                .stream()
                .map(r -> new PatientRecordSummaryDTO(r.getRecordId(), r.getDiagnose()))
                .collect(Collectors.toList());
    }

    public PatientRecordDetailDTO getRecordById(Long id) {
        PatientRecord r = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        return new PatientRecordDetailDTO(
                r.getRecordId(),
                r.getSymptoms(),
                r.getDiagnose(),
                r.getDate(),
                new DoctorSummaryDTO(r.getDoctor().getDoctorId(), r.getDoctor().getName(), r.getDoctor().getDesignation()),
                new ReportSummaryDTO(r.getReport().getReportId(), r.getReport().getReport()),
                null
        );
    }
}