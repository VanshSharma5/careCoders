package com._1shhub.carecoders.service;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.doctor.DoctorDetailDTO;
import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.models.Doctor;
import com._1shhub.carecoders.repositories.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorSummaryDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(d -> new DoctorSummaryDTO(d.getDoctorId(), d.getName(), d.getDesignation()))
                .collect(Collectors.toList());
    }

    public DoctorDetailDTO getDoctorById(Long id) {
        Doctor d = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return new DoctorDetailDTO(d.getDoctorId(), d.getName(), d.getAge(),
                d.getDesignation(), d.getDepartment(), d.getExperience());
    }
}

