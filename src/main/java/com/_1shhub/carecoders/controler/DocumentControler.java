package com._1shhub.carecoders.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com._1shhub.carecoders.service.DocumentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/document")
public class DocumentControler {

    private final DocumentService documentService;

	public DocumentControler(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
	public ResponseEntity<?> uploadDocument(@RequestParam("image")MultipartFile file, Long patientId) throws IOException {
		String uploadImage = documentService.uploadDocument(file, patientId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("{file}")
	public ResponseEntity<?> downloadDocument(@PathVariable String file,@RequestParam String type) throws IOException {
		byte[] imageData=documentService.downloadDocument(file);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf(type))
				.body(imageData);

	}

}
