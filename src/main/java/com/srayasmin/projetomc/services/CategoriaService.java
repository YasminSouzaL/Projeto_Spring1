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
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(
            () -> {
                throw new RuntimeException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
                );
            }
        );
    }
 
}
