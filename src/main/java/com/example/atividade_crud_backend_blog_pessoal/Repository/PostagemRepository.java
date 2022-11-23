package com.example.atividade_crud_backend_blog_pessoal.Repository;

import com.example.atividade_crud_backend_blog_pessoal.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
