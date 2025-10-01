package com._1shhub.carecoders.dto.patient;

import java.sql.Date;
import java.util.List;

import com._1shhub.carecoders.dto.addres.AddressDTO;
import com._1shhub.carecoders.dto.record.PatientRecordSummaryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetailDTO {
    private Long patientId;
    private String name;
    private int age;
    private String gender;
    private Date dateOfBirth;
    private String phone;
    private Date dateOfRegistration;
    private AddressDTO address;
    private List<PatientRecordSummaryDTO> records;
}