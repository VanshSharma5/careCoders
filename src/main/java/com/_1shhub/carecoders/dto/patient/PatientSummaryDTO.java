package com._1shhub.carecoders.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientSummaryDTO {
    private Long patientId;
    private String name;
    private String email;
}