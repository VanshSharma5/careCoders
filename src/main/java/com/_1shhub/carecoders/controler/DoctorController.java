package com._1shhub.carecoders.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.doctor.DoctorDetailDTO;
import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorSummaryDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDetailDTO getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}

