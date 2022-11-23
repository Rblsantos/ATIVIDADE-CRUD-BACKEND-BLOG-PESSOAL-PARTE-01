package com.example.atividade_crud_backend_blog_pessoal.Controller;

import com.example.atividade_crud_backend_blog_pessoal.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemrepository;

    @GetMapping
    private ResponseEntity<Object>getAll(){
        return ResponseEntity.ok(postagemrepository.findAll());
    }

}
