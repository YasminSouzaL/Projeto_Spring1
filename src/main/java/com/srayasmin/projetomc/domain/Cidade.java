package com.srayasmin.projetomc.domain;

public class Cidade {
    private Integer id;
    private String nome;
    // Cidade tem um estado:
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
}
