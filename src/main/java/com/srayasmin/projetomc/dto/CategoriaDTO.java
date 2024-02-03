package com.srayasmin.projetomc.dto;

import java.io.Serializable;

import com.srayasmin.projetomc.domain.Categoria;
/*
Isso não é mais necessário, pois as anotações de validação estão sendo feitas no DTO
import org.hibernate.validator.constraints.Lenght;
import org.hibernate.validator.constraints.NotEmpty;
*/
public class CategoriaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Lenght(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
