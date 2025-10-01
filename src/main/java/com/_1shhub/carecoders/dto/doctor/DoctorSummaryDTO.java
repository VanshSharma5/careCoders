package com._1shhub.carecoders.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSummaryDTO {
    private Long doctorId;
    private String name;
    private String designation;
}

