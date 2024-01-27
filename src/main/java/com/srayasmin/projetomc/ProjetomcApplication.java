package com.srayasmin.projetomc;

// No changes required for this code block.
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.domain.Produto;
import com.srayasmin.projetomc.repositores.CategoriaRepository;
import com.srayasmin.projetomc.repositores.ProdutoRepository;
@SpringBootApplication

public class ProjetomcApplication implements CommandLineRunner{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(ProjetomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Office");
        
        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        // Associando os produtos às categorias
        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        // Associando as categorias aos produtos
        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        // Salvando as categorias e produtos no banco de dados
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        
    }


}