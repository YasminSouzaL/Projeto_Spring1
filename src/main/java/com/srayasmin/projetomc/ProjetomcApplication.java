package com.srayasmin.projetomc;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.domain.Cidade;
import com.srayasmin.projetomc.domain.Estado;
import com.srayasmin.projetomc.domain.Produto;
import com.srayasmin.projetomc.repositores.CategoriaRepository;
import com.srayasmin.projetomc.repositores.CidadeRepository;
import com.srayasmin.projetomc.repositores.EstadoRepository;
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
        
        //Estados e cidades:
        Estado est1 = new Estado(null, "São Paulo");
        Estado est2 = new Estado(null, "Minas Gerais");

        Cidade c1 = new Cidade(null, "Belo Horizonte", est2);
        Cidade c2 = new Cidade(null, "Campinas", est1);
        Cidade c3 = new Cidade(null, "São Paulo", est1);

        // Associando as cidades aos estados
        est1.getCidades().addAll(Arrays.asList(c2, c3));
        est2.getCidades().addAll(Arrays.asList(c1));

        // Salvando os estados e cidades no banco de dados
        EstadoRepository.saveAll(Arrays.asList(est1, est2));
        CidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        
    }


}