package com._1shhub.carecoders.dto;

import com._1shhub.carecoders.dto.validators.CreatePatientValidationGroup;
import com._1shhub.carecoders.models.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientRequestDto(
        Long id,
        String imageUrl,
        @NotBlank(groups = CreatePatientValidationGroup.class) String name,
        String gender,
        String dateOfBirth,
        String phone,
        @Email String email,
        @NotBlank(groups = CreatePatientValidationGroup.class) String dateOfRegistration,
        Address address) {

}
