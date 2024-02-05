package com.srayasmin.projetomc.repository;

import com.srayasmin.projetomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    list<Cliente> findByNome(String nome);

}
