package com.srayasmin.projetomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.repositores.CategoriaRepository;
import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria buscar(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }
 
}
