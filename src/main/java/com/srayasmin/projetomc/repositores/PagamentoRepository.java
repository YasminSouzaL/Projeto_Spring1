package com.srayasmin.projetomc.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srayasmin.projetomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer>{
    Pagamento findOne(Integer id);

    <S> S save(Pagamento pagamento);
    
}
