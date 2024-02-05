package com.srayasmin.projetomc.services;

import java.util.List;
import java.util.Optional;


import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.dto.CategoriaDTO;
import com.srayasmin.projetomc.repository.CategoriaRepository;
import com.srayasmin.projetomc.services.exceptions.DataIntegrityException;
import com.srayasmin.projetomc.services.exceptions.ObjectNotFoundException;


@Service @Table(name="categoria")
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

    @SuppressWarnings("null")
    public void delete(Integer id) {
        find(id);
        try{
            repo.deleteById(id);
        }
        catch (DataIntegrityException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll() {
        return repo.findAll();
    }

    //page
    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        @SuppressWarnings("null")
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome());
    }

}
