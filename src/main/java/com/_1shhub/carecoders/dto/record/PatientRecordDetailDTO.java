package com._1shhub.carecoders.dto.record;

import java.sql.Date;

import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.dto.prescription.PrescriptionDTO;
import com._1shhub.carecoders.dto.report.ReportSummaryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRecordDetailDTO {
    private Long recordId;
    private String symptoms;
    private String diagnose;
    private Date date;
    private DoctorSummaryDTO doctor;
    private ReportSummaryDTO report;
    private PrescriptionDTO prescription; // optional
}