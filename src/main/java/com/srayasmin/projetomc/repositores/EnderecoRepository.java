package com.srayasmin.projetomc.repositores;

import com.srayasmin.projetomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    Endereco findOne(Integer id);

    <S> S save(Endereco endereco);
}
