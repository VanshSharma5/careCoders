package com._1shhub.carecoders.dto;

import org.springframework.web.multipart.MultipartFile;

public record DocumentUploadDto(
        MultipartFile image,
        String type,
        Long patientId) {

}
