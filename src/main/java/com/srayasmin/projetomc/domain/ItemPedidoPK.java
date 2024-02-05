package com.srayasmin.projetomc.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class ItemPedidoPK implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Getters and Setters

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemPedidoPK)) {
            return false;
        }
        ItemPedidoPK itemPedidoPK = (ItemPedidoPK) o;
        return Objects.equals(pedido, itemPedidoPK.pedido) && Objects.equals(produto, itemPedidoPK.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }

    

}
