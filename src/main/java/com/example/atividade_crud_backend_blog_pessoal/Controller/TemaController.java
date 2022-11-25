package com.example.atividade_crud_backend_blog_pessoal.Controller;

import com.example.atividade_crud_backend_blog_pessoal.Model.Postagem;
import com.example.atividade_crud_backend_blog_pessoal.Model.Tema;
import com.example.atividade_crud_backend_blog_pessoal.Repository.PostagemRepository;
import com.example.atividade_crud_backend_blog_pessoal.Repository.TemasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
    @Autowired
    private TemasRepository temasRepository;

    @GetMapping
    private ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(temasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id) {
        return temasRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Tema>> getDescricao(@PathVariable String descricao) {
        return ResponseEntity.ok(temasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Tema> postTema(@Valid @RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temasRepository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> putTema(@Valid @RequestBody Tema tema) {
        if (tema.getTema_id() == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(temasRepository.save(tema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTema(@PathVariable Long tema_id) {
        try {
            temasRepository.deleteById(tema_id);
            return ResponseEntity.status(204).build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
}
