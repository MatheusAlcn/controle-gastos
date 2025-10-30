package com.MatheusAlcn.controle_gastos.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("Categoria com ID " + id + " não encontrada.");
    }
}

