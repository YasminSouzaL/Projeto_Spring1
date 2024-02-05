package com.srayasmin.projetomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srayasmin.projetomc.domain.Pedido;
import com.srayasmin.projetomc.repository.PedidoRepository;
import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        @SuppressWarnings("null")
        Optional<Pedido> obj = repo.findById(id);
        if(obj.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                    + ", Tipo: " + Pedido.class.getName());
        }
        return obj.get();
    }
}
