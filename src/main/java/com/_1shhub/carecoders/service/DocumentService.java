package com._1shhub.carecoders.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com._1shhub.carecoders.models.Document;
import com._1shhub.carecoders.repositories.DocumentRepository;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final String FILE_PATH = "/tmp/media/";

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public String uploadDocument(MultipartFile file, Long patientId) throws IllegalStateException, IOException {
        UUID fileName = UUID.randomUUID();
        String filePath = FILE_PATH+fileName.toString();

        Document document = documentRepository.save(Document.builder()
                .fileName(fileName.toString())
                .fileType(file.getContentType())
                .filePath(filePath).patinetId(patientId).build());
    
        file.transferTo(new File(filePath));
        
        return "File saved success "+fileName;
    }

    public byte[] downloadDocument(String fileName) throws IllegalStateException, IOException {
        Optional<Document> document = documentRepository.findByFileName(fileName);
        String filePath = document.get().getFilePath();

        byte[] docs = Files.readAllBytes(new File(filePath).toPath());

        return docs;
    }

    public List<Document> findByPatientId(Long id) {
        return documentRepository.findByPatinetId(id);
    }
}
