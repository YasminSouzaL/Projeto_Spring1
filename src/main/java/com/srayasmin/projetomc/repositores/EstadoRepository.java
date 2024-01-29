package com.srayasmin.projetomc.repositores;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.srayasmin.projetomc.domain.Cidade;
import com.srayasmin.projetomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Cidade, Integer> {
    public List<Cidade> findByEstado(Integer estadoId);

    public static void saveAll(List<Estado> asList) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }
}

