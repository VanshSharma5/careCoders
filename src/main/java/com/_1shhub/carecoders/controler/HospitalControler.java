package com._1shhub.carecoders.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.models.Hospital;
import com._1shhub.carecoders.service.HospitalService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/hospital")
@AllArgsConstructor
public class HospitalControler {
    
    private final HospitalService hospitalService;

    @GetMapping
    public List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }
    
    @GetMapping("{id}")
    public Hospital getHospitals(@PathVariable Long id) {
        return hospitalService.getHospitalById(id);
    }

    @PostMapping
    public Hospital postHospital(@RequestBody Hospital hospital) {       
        return hospitalService.postHospital(hospital);
    }
    
    
    
}
