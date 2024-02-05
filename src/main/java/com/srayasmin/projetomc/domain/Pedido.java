package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="endereco_entrega_id")
    private Endereco enderecoDeEntrega;
    
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(){}

    public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega){
        super();
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    // Getters e Setters
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Date getInstante(){
        return this.instante;
    }

    public void setInstante(Date instante){
        this.instante = instante;
    }

    public Pagamento getPagamento(){
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento){
        this.pagamento = pagamento;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega(){
        return this.enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega){
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens(){
        return this.itens;
    }

    public void setItens(Set<ItemPedido> itens){
        this.itens = itens;
    }

    // HashCode e Equals
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        //result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        //result = prime * result + ((enderecoDeEntrega == null) ? 0 : enderecoDeEntrega.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        //result = prime * result + ((instante == null) ? 0 : instante.hashCode());
        //result = prime * result + ((pagamento == null) ? 0 : pagamento.hashCode());
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
        Pedido other = (Pedido) obj;
        if(cliente == null){
            if(other.cliente != null){
                return false;
            }
        }else if(!cliente.equals(other.cliente)){
            return false;
        }
        if(enderecoDeEntrega == null){
            if(other.enderecoDeEntrega != null){
                return false;
            }
        }else if(!enderecoDeEntrega.equals(other.enderecoDeEntrega)){
            return false;
        }
        if(id == null){
            if(other.id != null){
                return false;
            }
        }else if(!id.equals(other.id)){
            return false;
        }
        if(instante == null){
            if(other.instante != null){
                return false;
            }
        }else if(!instante.equals(other.instante)){
            return false;
        }
        if(pagamento == null){
            if(other.pagamento != null){
                return false;
            }
        }else if(!pagamento.equals(other.pagamento)){
            return false;
        }
        return true;
    }
}
