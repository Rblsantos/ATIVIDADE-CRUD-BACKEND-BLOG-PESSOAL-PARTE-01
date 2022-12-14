package com.example.atividade_crud_backend_blog_pessoal.Repository;

import com.example.atividade_crud_backend_blog_pessoal.Model.Postagem;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);
}
