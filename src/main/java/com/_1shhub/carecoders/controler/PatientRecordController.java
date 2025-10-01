package com._1shhub.carecoders.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.record.PatientRecordDetailDTO;
import com._1shhub.carecoders.dto.record.PatientRecordSummaryDTO;
import com._1shhub.carecoders.service.PatientRecordService;

@RestController
@RequestMapping("/api/records")
public class PatientRecordController {
    private final PatientRecordService recordService;

    public PatientRecordController(PatientRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public List<PatientRecordSummaryDTO> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public PatientRecordDetailDTO getRecord(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }
}
