package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(){}

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco){
        super();
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters]
    @JsonIgnore
    public Pedido getPedido(){
        return this.id.getPedido();
    }

    public Produto getProduto(){
        return this.id.getProduto();
    }

    public ItemPedidoPK getId(){
        return this.id;
    }

    public void setId(ItemPedidoPK id){
        this.id = id;
    }

    public Double getDesconto(){
        return this.desconto;
    }

    public void setDesconto(Double desconto){
        this.desconto = desconto;
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Double getPreco(){
        return this.preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    // HashCode and Equals
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemPedido)) {
            return false;
        }
        ItemPedido itemPedido = (ItemPedido) o;
        return id.equals(itemPedido.id);
    }
}
