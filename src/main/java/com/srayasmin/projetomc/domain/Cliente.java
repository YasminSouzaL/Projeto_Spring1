package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.srayasmin.projetomc.domain.enums.TipoCliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;
    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(){}

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo){
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();
    }

     // Getters e Setters
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCpfOuCnpj(){
        return this.cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj){
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo(){
        return TipoCliente.toEnum(this.tipo);
    }

    public void setTipo(TipoCliente tipo){
        this.tipo = tipo.getCod();
    }

    public List<Endereco> getEnderecos(){
        return this.enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos){
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones(){
        return this.telefones;
    }

    public void setTelefones(Set<String> telefones){
        this.telefones = telefones;
    }

    public List<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    // HashCode e Equals
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpfOuCnpj == null) ? 0 : cpfOuCnpj.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Cliente other = (Cliente) obj;
        if(cpfOuCnpj == null){
            if(other.cpfOuCnpj != null){
                return false;
            }
        }else if(!cpfOuCnpj.equals(other.cpfOuCnpj)){
            return false;
        }
        if(email == null){
            if(other.email != null){
                return false;
            }
        }else if(!email.equals(other.email)){
            return false;
        }
        return true;
    }

   
}
