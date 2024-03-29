package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido){
        super();
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    // Getters e Setters
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public EstadoPagamento getEstado(){
        return EstadoPagamento.toEnum(this.estado);
    }

    public void setEstado(EstadoPagamento estado){
        this.estado = estado.getCod();
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    // HashCode e Equals
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Pagamento other = (Pagamento) obj;
        if(estado != other.estado){
            return false;
        }
        if(id == null){
            if(other.id != null){
                return false;
            }
        }else if(!id.equals(other.id)){
            return false;
        }
        if(pedido == null){
            if(other.pedido != null){
                return false;
            }
        }else if(!pedido.equals(other.pedido)){
            return false;
        }
        return true;
    }

}
