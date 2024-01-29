package com.srayasmin.projetomc.repositores;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srayasmin.projetomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    public List<Cidade> findByEstado(Integer estadoId);
}
