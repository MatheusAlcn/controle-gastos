package com.MatheusAlcn.controle_gastos.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
public class GlobalExceptionHandler {



    @RestControllerAdvice
    public class globalExceptionHandler {

        @ExceptionHandler(CategoriaNotFoundException.class)
        public ResponseEntity<String> handleCategoriaNotFound(CategoriaNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGeneric(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
        }
    }
}
