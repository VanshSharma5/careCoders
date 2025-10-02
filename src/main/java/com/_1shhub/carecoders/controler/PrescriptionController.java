package com._1shhub.carecoders.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com._1shhub.carecoders.dto.prescription.PrescriptionDTO;
import com._1shhub.carecoders.service.FileStorageService;
import com._1shhub.carecoders.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final FileStorageService fileStorageService;

    @PostMapping("/{recordId}/upload")
    public PrescriptionDTO uploadPrescription(@PathVariable Long recordId, @RequestParam("file") MultipartFile file) {
        String path = fileStorageService.storeFile(file);
        return prescriptionService.attachFile(recordId, file.getOriginalFilename(), file.getContentType(), path);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadPrescription(@PathVariable Long id) {
        PrescriptionDTO dto = prescriptionService.getById(id);
        Resource resource = fileStorageService.loadFile(dto.getDownloadUrl().replace("/api/prescriptions/" + id + "/download", dto.getFileName()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dto.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(dto.getFileType()))
                .body(resource);
    }
}

