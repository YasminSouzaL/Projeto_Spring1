package com.srayasmin.projetomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.srayasmin.projetomc.domain.enums.EstadoPagamento;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private EstadoPagamento estado;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido){
        super();
        this.id = id;
        this.estado = estado;
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
        return this.estado;
    }

    public void setEstado(EstadoPagamento estado){
        this.estado = estado;
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