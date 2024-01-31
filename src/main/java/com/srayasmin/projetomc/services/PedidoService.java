package com.srayasmin.projetomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srayasmin.projetomc.domain.Pedido;
import com.srayasmin.projetomc.repositores.PedidoRepository;
import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Pedido obj = repo.findOne(id);
        if(obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                    + ", Tipo: " + Pedido.class.getName());
        }
        return obj;
    }
}
