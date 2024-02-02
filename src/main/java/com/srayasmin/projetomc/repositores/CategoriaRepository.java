package com.srayasmin.projetomc.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srayasmin.projetomc.domain.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer>{

    Object saveAll = null;

    Categoria findOne(Integer id);

    void save(List<Categoria> asList);
}
