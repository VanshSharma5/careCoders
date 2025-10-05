package com._1shhub.carecoders.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.PatientDto;
import com._1shhub.carecoders.dto.PseudoPatientLogin;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.service.PatientService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientControler {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getPatientDto() {
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @PostMapping
    public ResponseEntity<PatientDto> postPatient(@RequestBody PatientDto dto) {
        return ResponseEntity.ok().body(patientService.postPatient(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> postPatient(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(patientService.getPatientById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<List<Patient>> getPatientLogin(@RequestBody PseudoPatientLogin pLogin) {
        System.out.println(pLogin);
        return ResponseEntity.ok().body(patientService.getPatientByEmailAndPassword(pLogin.email(), pLogin.password())); 
    }
    
    
}
