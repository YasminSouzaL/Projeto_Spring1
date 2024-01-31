package com.srayasmin.projetomc.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srayasmin.projetomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
    Pedido findOne(Integer id);

    <S> S save(Pedido pedido);
    
}
