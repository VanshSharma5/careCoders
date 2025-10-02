package com._1shhub.carecoders.mapper;

import com._1shhub.carecoders.dto.record.PatientRecordSummaryDTO;
import com._1shhub.carecoders.models.PatientRecord;

public class ReportMapper {

    public static PatientRecordSummaryDTO recordToRecordSummary(PatientRecord record) {
        return new PatientRecordSummaryDTO(record.getRecordId(), record.getDiagnose());
    }

}
