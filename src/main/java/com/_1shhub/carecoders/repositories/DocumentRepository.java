package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Document;
import java.util.Optional;


public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findByFileName(String fileName);
}