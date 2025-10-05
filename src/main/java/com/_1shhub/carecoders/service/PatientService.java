package com._1shhub.carecoders.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.PatientDto;
import com._1shhub.carecoders.mapper.PatientMapper;
import com._1shhub.carecoders.models.Address;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.repositories.AddressRepository;
import com._1shhub.carecoders.repositories.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;
    private final PatientMapper patientMapper;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(new Patient());
    }

    public PatientDto postPatient(PatientDto dto) {
        Address address = addressRepository.save(Address.builder()
        .city(dto.address().getCity())
        .state(dto.address().getState())
        .pinCode(dto.address().getPinCode())
        .build());
        Patient patient = patientRepository.save(Patient.builder()
                .name(dto.name())
                .imageUrl(dto.imageUrl())
                .gender(dto.gender()) 
                .password(dto.password())
                .dateOfBirth(LocalDate.parse(dto.dateOfBirth()))
                .phone(dto.phone())
                .email(dto.email())
                .dateOfRegistration(LocalDate.parse(dto.dateOfRegistration()))
                .lAddressId(address.getAddressId()).build());
        return patientMapper.patientToPatientDto(patient);
    }

    public List<Patient> getPatientByEmailAndPassword(String email, String password) {
        return patientRepository.getByEmailAndPassword(email, password);
    }

}
