package com.srayasmin.projetomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srayasmin.projetomc.domain.Cliente;
import com.srayasmin.projetomc.repositores.ClienteRepository;
import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }

    public Cliente buscar(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }
 
}
