package com._1shhub.carecoders.service;

// PatientServiceImpl.java
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.addres.AddressDTO;
import com._1shhub.carecoders.dto.patient.PatientDetailDTO;
import com._1shhub.carecoders.dto.patient.PatientSummaryDTO;
import com._1shhub.carecoders.models.Address;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.repositories.AddressRepository;
import com._1shhub.carecoders.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService{
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    public List<PatientSummaryDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(p -> new PatientSummaryDTO(p.getPatientId(), p.getName(), p.getEmail()))
                .collect(Collectors.toList());
    }

    public PatientDetailDTO getPatientById(Long id) {
        Patient p = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return new PatientDetailDTO(
                p.getPatientId(),
                p.getName(),
                p.getAge(),
                p.getGender(),
                p.getEmail(),
                p.getDateOfBirth(),
                p.getPhone(),
                p.getDateOfRegistration(),
                new AddressDTO(p.getAddress().getHouseNo(), p.getAddress().getStreet(),
                               p.getAddress().getCity(), p.getAddress().getState(),
                               p.getAddress().getPinCode()),
                null
        );
    }

    public PatientDetailDTO createPatient(PatientDetailDTO dto) {
        Address address = new Address(null,
                dto.getAddress().getHouseNo(),
                dto.getAddress().getStreet(),
                dto.getAddress().getCity(),
                dto.getAddress().getState(),
                dto.getAddress().getPinCode(),
                null);

        addressRepository.save(address);

        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setPhone(dto.getPhone());
        patient.setEmail(dto.getEmail());
        patient.setDateOfRegistration(dto.getDateOfRegistration());
        patient.setAddress(address);

        Patient saved = patientRepository.save(patient);

        return getPatientById(saved.getPatientId());
    }
}
