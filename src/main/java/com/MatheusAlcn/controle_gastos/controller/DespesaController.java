package com.MatheusAlcn.controle_gastos.controller;

import com.MatheusAlcn.controle_gastos.entity.Despesa;
import com.MatheusAlcn.controle_gastos.repository.DespesaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaRepository repo;

    public DespesaController(DespesaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarPorId(@PathVariable Long id){
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa) {
        Despesa novaDespesa = repo.save(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDespesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa body) {
        return repo.findById(id).map(c -> {
            c.setDescricao(body.getDescricao());
            c.setValor(body.getValor());
            c.setData(body.getData());
            c.setCategoria(body.getCategoria());
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
