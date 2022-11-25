package com.example.atividade_crud_backend_blog_pessoal.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "tb_temas")
public class Tema {

    @OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties ("tema")
    private List<Postagem> postagem;

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tema_id;

    public Long getTema_id() {
        return tema_id;
    }

    public void setTema_id(Long tema_id) {
        this.tema_id = tema_id;
    }

    @NotBlank (message = "A descrição não pode ser nula ou vazia!")
    @Size(min = 1, max = 1000, message = "O texto deve ter entre 1 e 1000 caracteres" )
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
