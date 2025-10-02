package com._1shhub.carecoders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com._1shhub.carecoders.dto.addres.AddressDTO;
import com._1shhub.carecoders.dto.doctor.DoctorSummaryDTO;
import com._1shhub.carecoders.dto.patient.PatientDetailDTO;
import com._1shhub.carecoders.dto.patient.PatientSummaryDTO;
import com._1shhub.carecoders.dto.record.PatientRecordDetailDTO;
import com._1shhub.carecoders.dto.record.PatientRecordSummaryDTO;
import com._1shhub.carecoders.mapper.ReportMapper;
import com._1shhub.carecoders.models.Address;
import com._1shhub.carecoders.models.Doctor;
import com._1shhub.carecoders.models.Patient;
import com._1shhub.carecoders.models.PatientRecord;
import com._1shhub.carecoders.repositories.DoctorRepository;
import com._1shhub.carecoders.repositories.PatientRecordRepository;
import com._1shhub.carecoders.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRecordRepository recordRepository;

    public PatientDetailDTO createPatient(PatientDetailDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setPhone(dto.getPhone());
        patient.setEmail(dto.getEmail());
        patient.setDateOfRegistration(dto.getDateOfRegistration());
        patient.setAddress(new Address(dto.getAddress().getHouseNo(),
                dto.getAddress().getStreet(), dto.getAddress().getCity(),
                dto.getAddress().getState(), dto.getAddress().getPinCode(), null));
        patientRepository.save(patient);

        return dto;
    }

    public PatientDetailDTO getPatientById(Long id) {
        Patient p = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        List<PatientRecordSummaryDTO> recordSummary = recordRepository.findAll()
                .stream()
                .map(ReportMapper::recordToRecordSummary)
                .toList();

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
                recordSummary
        );
    }

    public List<PatientSummaryDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(p -> new PatientSummaryDTO(p.getPatientId(), p.getName(), p.getEmail()))
                .collect(Collectors.toList());
    }

    public PatientRecordDetailDTO addRecord(Long patientId, PatientRecordDetailDTO recordDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(recordDTO.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        PatientRecord record = new PatientRecord();
        record.setSymptoms(recordDTO.getSymptoms());
        record.setDiagnose(recordDTO.getDiagnose());
        record.setDate(recordDTO.getDate());
        record.setPatient(patient);
        record.setDoctor(doctor);

        PatientRecord saved = recordRepository.save(record);

        return new PatientRecordDetailDTO(
                saved.getRecordId(),
                saved.getSymptoms(),
                saved.getDiagnose(),
                saved.getDate(),
                new DoctorSummaryDTO(doctor.getDoctorId(), doctor.getName(), doctor.getDesignation()),
                null,
                null);
    }
}