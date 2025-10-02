package com._1shhub.carecoders.dto.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private Long prescriptionId;
    private String details;
    private String fileName;
    private String fileType;
    private String downloadUrl; // built from REST endpoint
}


