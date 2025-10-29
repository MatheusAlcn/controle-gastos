package com.MatheusAlcn.controle_gastos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "despesas")
@NoArgsConstructor
@AllArgsConstructor

public class Despesa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "despesa", nullable = false)
        private String descricao;

        @Column(nullable = false)
         private BigDecimal valor;

        @Column(nullable = false)
        private LocalDate data;

        @Column(nullable = false)
        private String categoria;


}
