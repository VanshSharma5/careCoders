package com._1shhub.carecoders.models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    // File metadata
    private String fileName;
    private String fileType;
    private String filePath; // absolute or relative path in file system

    private Long patinetId;
    // @ManyToOne
    // @JoinColumn(name = "recordId")
    // private PatientRecord record;
}
