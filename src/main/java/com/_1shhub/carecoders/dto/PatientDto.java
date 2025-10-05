package com._1shhub.carecoders.dto;

import com._1shhub.carecoders.models.Address;

public record PatientDto(
        Long patientId,
        String imageUrl,
        String name,
        String gender,
        String dateOfBirth,
        String phone,
        String email,
        String password,
        String dateOfRegistration,

        Address address) {

}
