package com._1shhub.carecoders.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.PatientRequestDto;
import com._1shhub.carecoders.dto.PatientResponceDto;
import com._1shhub.carecoders.mapper.PatientMapper;
import com._1shhub.carecoders.models.Address;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.repositories.AddressRepository;
import com._1shhub.carecoders.repositories.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    public PatientService(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    public List<PatientResponceDto> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::patientToPatientResponceDto)
                .toList();
    }

    public PatientResponceDto postPatient(PatientRequestDto dto) {
        Address address = new Address();
        address.setHouseNo(dto.address().getHouseNo());
        address.setCity(dto.address().getCity());
        address.setPinCode(dto.address().getPinCode());
        address.setState(dto.address().getState());
        address.setState(dto.address().getState());
        address.setRegion(dto.address().getRegion());

        Address savedAddress = addressRepository.save(address);

        Patient patient = new Patient();
        patient.setImageUrl(dto.imageUrl());
        patient.setName(dto.name());
        patient.setGender(dto.gender());
        patient.setDateOfBirth(LocalDate.parse(dto.dateOfBirth()));
        patient.setPhone(dto.phone());
        patient.setEmail(dto.email());
        patient.setDateOfRegistration(LocalDate.parse(dto.dateOfRegistration()));
        patient.setAddress(savedAddress);

        patientRepository.save(patient);

        return PatientMapper.patientToPatientResponceDto(patient);
    }

    public Optional<PatientResponceDto> getPatientById(Long id) {
        return Optional.ofNullable(PatientMapper.patientToPatientResponceDto(patientRepository.getById(id)));
    }

}
