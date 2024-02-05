package com.srayasmin.projetomc.domain;

import jakarta.persistence.Entity;
@Entity
public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;
    private Integer numeroDeParcelas;

    public PagamentoComCartao(Integer id, com.srayasmin.projetomc.domain.enums.EstadoPagamento quitado, Pedido ped1, int numeroDeParcelas) {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas){
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    // Getters e Setters
    public Integer getNumeroDeParcelas(){
        return this.numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas){
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
