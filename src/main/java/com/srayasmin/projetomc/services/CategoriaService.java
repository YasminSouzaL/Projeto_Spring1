package com.srayasmin.projetomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.repositores.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria not found for ID: " + id));
    }
    // ObjectNotFoundException.java
    public class ObjectNotFoundException extends RuntimeException {
        public ObjectNotFoundException(String message) {
            super(message);
        }
    }
    public Categoria buscar(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    
}
