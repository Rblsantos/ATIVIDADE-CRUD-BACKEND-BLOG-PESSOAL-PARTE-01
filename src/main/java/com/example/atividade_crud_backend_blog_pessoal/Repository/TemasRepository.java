package com.example.atividade_crud_backend_blog_pessoal.Repository;

import com.example.atividade_crud_backend_blog_pessoal.Model.Postagem;
import com.example.atividade_crud_backend_blog_pessoal.Model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemasRepository extends JpaRepository <Tema, Long>{
    public List<Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);
}


