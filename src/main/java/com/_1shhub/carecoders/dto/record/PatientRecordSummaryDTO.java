package com._1shhub.carecoders.dto.record;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRecordSummaryDTO {
    private Long recordId;
    private String diagnose;
}

