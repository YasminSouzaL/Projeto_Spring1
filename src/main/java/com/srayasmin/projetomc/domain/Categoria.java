package com.srayasmin.projetomc.domain;

import java.io.Serializable;

public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    public Categoria(){}

    public Categoria(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    // HashCode e Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // Se o objeto for o mesmo, retorna true
        if (this == obj)
            return true;
        // Se o objeto for nulo ou de uma classe diferente, retorna false
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        // Se o objeto tiver o mesmo id, retorna true
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
            // Se o objeto tiver id diferente, retorna false
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}