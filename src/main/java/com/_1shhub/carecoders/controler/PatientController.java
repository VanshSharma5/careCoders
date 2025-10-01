package com._1shhub.carecoders.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.patient.PatientDetailDTO;
import com._1shhub.carecoders.dto.patient.PatientSummaryDTO;
import com._1shhub.carecoders.service.PatientService;


@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientSummaryDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDetailDTO getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public PatientDetailDTO createPatient(@RequestBody PatientDetailDTO dto) {
        return patientService.createPatient(dto);
    }
}
