package com.onseo.online_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> anyException(Exception exc) {
        return ResponseEntity
                .badRequest()
                .body("something go wrong");
    }
}
