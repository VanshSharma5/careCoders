package com._1shhub.carecoders.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException excep) {

        Map<String, String> exceptions = new HashMap<>();

        excep.getBindingResult().getFieldErrors().forEach(
                exception -> exceptions.put(exception.getField(), exception.getDefaultMessage()));

        return ResponseEntity.badRequest().body(exceptions);
    }
}
