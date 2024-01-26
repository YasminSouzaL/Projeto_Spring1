package com.srayasmin.projetomc.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srayasmin.projetomc.domain.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer>{

    Categoria findOne(Integer id);
}
