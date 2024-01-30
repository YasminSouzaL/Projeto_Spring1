package com.srayasmin.projetomc.domain;

import javax.persistence.Entity;

import com.srayasmin.projetomc.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
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
