package com._1shhub.carecoders.mapper;

import org.springframework.stereotype.Component;

import com._1shhub.carecoders.dto.PatientDto;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.repositories.AddressRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PatientMapper {
    private final AddressRepository addressRepository;

    public PatientDto patientToPatientDto(Patient patient) {

        return new PatientDto(patient.getPatientId(), patient.getImageUrl(), patient.getName(), patient.getGender(),
                patient.getDateOfBirth().toString(), patient.getPhone(), patient.getEmail(), patient.getPassword(), patient.getDateOfRegistration().toString(),
                addressRepository.getById(patient.getLAddressId()));
    }
}
