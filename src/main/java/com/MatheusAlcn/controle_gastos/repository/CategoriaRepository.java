package com.MatheusAlcn.controle_gastos.repository;

import com.MatheusAlcn.controle_gastos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
}
