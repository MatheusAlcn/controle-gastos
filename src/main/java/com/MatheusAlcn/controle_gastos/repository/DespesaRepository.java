package com.MatheusAlcn.controle_gastos.repository;

import com.MatheusAlcn.controle_gastos.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository <Despesa, Long> {
}
