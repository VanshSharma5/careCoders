package com._1shhub.carecoders.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.PatientRequestDto;
import com._1shhub.carecoders.dto.PatientResponceDto;
import com._1shhub.carecoders.service.PatientService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponceDto>> getPatients() {
        // get all patients
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponceDto> postPatient(@RequestBody PatientRequestDto patientRequestDto) {        
        return ResponseEntity.ok().body(patientService.postPatient(patientRequestDto));
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Optional<PatientResponceDto>> postMethodName(@PathVariable Long id) {
        return ResponseEntity.ok().body(patientService.getPatientById(id));
    }
        
}
