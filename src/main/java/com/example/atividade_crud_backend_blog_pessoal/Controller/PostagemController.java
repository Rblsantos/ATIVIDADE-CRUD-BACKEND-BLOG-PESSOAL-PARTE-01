package com.example.atividade_crud_backend_blog_pessoal.Controller;

import com.example.atividade_crud_backend_blog_pessoal.Model.Postagem;
import com.example.atividade_crud_backend_blog_pessoal.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    private ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        return postagemRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
        if (postagem.getId() == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostagem(@PathVariable Long id) {
        try {
            postagemRepository.deleteById(id);
            return ResponseEntity.status(204).build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
}