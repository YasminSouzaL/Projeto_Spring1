package com.srayasmin.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;

import java.util.Date;
@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, com.srayasmin.projetomc.domain.enums.EstadoPagamento pendente, Pedido ped2, Date parse, Object dataPagamento) {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento){
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    // Getters e Setters
    public Date getDataVencimento(){
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento){
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento(){
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento){
        this.dataPagamento = dataPagamento;
    }

    

}
