package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    
    private List<Categoria> categorias = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private List<ItemPedido> itens = new ArrayList<>();

    public Produto(){}

    public Produto(Integer id, String nome, Double preco) {
        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    
    @JsonIgnore
    //Lista de pedidos
    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
    }
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco(){
        return preco;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Categoria> getCategorias(){
        return categorias;
    }
  
    public void setCategorias(List<Categoria> categorias){
        this.categorias = categorias;
    }

    public List<ItemPedido> getItens(){
        return itens;
    }

    public void setItens(List<ItemPedido> itens){
        this.itens = itens;
    }

    // HashCode e Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
            // Se o objeto tiver id diferente, retorna false
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    

}
