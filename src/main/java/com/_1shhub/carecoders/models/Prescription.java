package com._1shhub.carecoders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    private String details;

    // File metadata
    private String fileName;
    private String fileType;
    private String filePath; // absolute or relative path in file system

    @OneToOne(mappedBy = "prescription")
    private PatientRecord patientRecord;
}
