package com.srayasmin.projetomc.domain;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    private Integer id;
    private String nome;

    //Estado tem varias cidades:private List<Cidade> cidades = new ArrayList<>();
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {}

    public Estado(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    // Getters and Setters:
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public List<Cidade> getCidades() {return cidades;}

    //hasCode and equals:
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = prime * result + ((cidades == null) ? 0 : cidades.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        //result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(obj == null) {return false;}
        if(getClass() != obj.getClass()) {return false;}
        Estado other = (Estado) obj;
        if(id == null) {
            if(other.id != null) {return false;}
        } else if(!id.equals(other.id)) {return false;}
        return true;
    }
}