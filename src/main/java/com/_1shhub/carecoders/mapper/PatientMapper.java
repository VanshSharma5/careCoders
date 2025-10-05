package com._1shhub.carecoders.mapper;

import java.time.LocalDate;

import com._1shhub.carecoders.dto.PatientRequestDto;
import com._1shhub.carecoders.dto.PatientResponceDto;
import com._1shhub.carecoders.models.Patient;

public class PatientMapper {
    public static PatientResponceDto patientToPatientResponceDto(Patient patient) {
        PatientResponceDto dto = new PatientResponceDto(patient.getPatientId(), patient.getImageUrl(),
                patient.getName(), patient.getGender(), patient.getDateOfBirth().toString(), patient.getPhone(),
                patient.getEmail(), patient.getDateOfRegistration().toString(), patient.getAddress());

        return dto;

    }

    public static Patient patientRequestDtoToPatient(PatientRequestDto dto) {
        Patient patient = new Patient(dto.id(), dto.imageUrl(), dto.name(), dto.gender(), LocalDate.parse(dto.dateOfBirth()),
                dto.phone(), dto.email(), LocalDate.parse(dto.dateOfRegistration()), dto.address(), null);

        return patient;
    }

}
