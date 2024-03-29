package com.srayasmin.projetomc.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Cidade implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    // Cidade tem um estado:
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade() {}

    public Cidade(Integer id, String nome, Estado estado) {
        super();
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    // Getters and Setters:
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Estado getEstado() {return estado;}

    //hasCode and equals:
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        //result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(obj == null) {return false;}
        if(getClass() != obj.getClass()) {return false;}
        Cidade other = (Cidade) obj;
        if(getId() == null) {
            if(other.getId() != null) {return false;}
        } else if(!getId().equals(other.getId())) {return false;}
        return true;
    }
}
