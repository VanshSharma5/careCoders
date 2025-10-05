package com._1shhub.carecoders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.models.Hospital;
import com._1shhub.carecoders.repositories.HospitalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).orElse(new Hospital());
    }

    public Hospital postHospital(Hospital hospital) {
        return hospitalRepository.save(Hospital.builder()
        .name(hospital.getName())
        .imageUrl(hospital.getImageUrl())
        .phon(hospital.getPhon())
        .Email(hospital.getEmail())
        .gOPDFees(hospital.getGOPDFees())
        .pOPDFees(hospital.getPOPDFees())
        .build());
    }
}
