package com._1shhub.carecoders.dto;

import com._1shhub.carecoders.models.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientResponceDto(
        @NotBlank Long id,
        String imageUrl,
        String name,
        String gender,
        String dateOfBirth,
        String phone,
        @Email String email,
        String dateOfRegistration,
        Address address) {

}
