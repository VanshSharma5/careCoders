package com._1shhub.carecoders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.prescription.PrescriptionDTO;
import com._1shhub.carecoders.models.PatientRecord;
import com._1shhub.carecoders.models.Prescription;
import com._1shhub.carecoders.repositories.PatientRecordRepository;
import com._1shhub.carecoders.repositories.PrescriptionRepository;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRecordRepository recordRepository;

    public PrescriptionDTO getById(Long id) {
        Prescription p = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        return new PrescriptionDTO(
                p.getPrescriptionId(),
                p.getDetails(),
                p.getFileName(),
                p.getFileType(),
                "/api/prescriptions/" + p.getPrescriptionId() + "/download"
        );
    }

    public PrescriptionDTO attachFile(Long recordId, String fileName, String fileType, String filePath) {
        PatientRecord record = recordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        Prescription p = record.getPrescription();
        if (p == null) {
            p = new Prescription();
            p.setDetails("Uploaded prescription file");
        }

        p.setFileName(fileName);
        p.setFileType(fileType);
        p.setFilePath(filePath);

        prescriptionRepository.save(p);
        record.setPrescription(p);
        recordRepository.save(record);

        return getById(p.getPrescriptionId());
    }
}

