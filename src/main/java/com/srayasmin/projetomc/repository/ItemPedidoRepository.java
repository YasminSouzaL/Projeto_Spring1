package com.srayasmin.projetomc.repository;

import com.srayasmin.projetomc.domain.ItemPedido;
import com.srayasmin.projetomc.domain.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
        
}
