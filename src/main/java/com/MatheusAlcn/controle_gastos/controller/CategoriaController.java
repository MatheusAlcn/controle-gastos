package com.MatheusAlcn.controle_gastos.controller;


import com.MatheusAlcn.controle_gastos.entity.Categoria;
import com.MatheusAlcn.controle_gastos.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
     public ResponseEntity<List<Categoria>> listarTodos() {
         return ResponseEntity.ok(repo.findAll());
     }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        categoria.setId(null);
        Categoria novaCategoria = repo.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
     }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria body) {
        return repo.findById(id).map(c -> {
            c.setNome(body.getNome());
            return ResponseEntity.ok(repo.save(c));
        }).orElse(ResponseEntity.notFound().build());
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id) {
         if (!repo.existsById(id)) return ResponseEntity.notFound().build();
         repo.deleteById(id);
         ResponseEntity<Void> build = ResponseEntity.noContent().build();
         return build;
     }
}


