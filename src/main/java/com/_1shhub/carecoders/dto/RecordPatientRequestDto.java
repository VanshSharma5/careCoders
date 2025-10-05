package com._1shhub.carecoders.dto;


import com._1shhub.carecoders.models.Document;

public record RecordPatientRequestDto(
    Long patientId,
    String symptoms,
    String bloodPressure,
    Float bloodSugar,
    Float weight,
    Document document) {
}
