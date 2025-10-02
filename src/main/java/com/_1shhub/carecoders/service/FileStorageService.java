package com._1shhub.carecoders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    public String storeFile(MultipartFile file) {
        try {
            Path dirPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(dirPath);

            Path filePath = dirPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("File storage failed", e);
        }
    }

    public Resource loadFile(String filePath) {
        return new FileSystemResource(filePath);
    }
}

