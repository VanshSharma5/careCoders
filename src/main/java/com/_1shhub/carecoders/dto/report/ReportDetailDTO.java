package com._1shhub.carecoders.dto.report;

import java.sql.Date;

import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDetailDTO {
    private Long reportId;
    private String report;
    private Date dateOfSample;
    private Date dateOfReport;
    private DoctorSummaryDTO doctor;
}