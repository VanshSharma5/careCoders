package com._1shhub.carecoders.dto;

import org.springframework.web.multipart.MultipartFile;

public record DocumentRequestDto(
        MultipartFile file) {

}
