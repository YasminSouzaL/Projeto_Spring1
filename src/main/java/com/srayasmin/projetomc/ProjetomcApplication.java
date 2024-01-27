package com.srayasmin.projetomc;

// No changes required for this code block.
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.repositores.CategoriaRepository;
@SpringBootApplication

public class ProjetomcApplication implements CommandLineRunner{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Office");
        
        categoriaRepository.save(Arrays.asList(cat1, cat2));
    }


}