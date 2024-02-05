package com.srayasmin.projetomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.srayasmin.projetomc.domain.Categoria;
import com.srayasmin.projetomc.domain.Cidade;
import com.srayasmin.projetomc.domain.Cliente;
import com.srayasmin.projetomc.domain.Endereco;
import com.srayasmin.projetomc.domain.Estado;
import com.srayasmin.projetomc.domain.ItemPedido;
import com.srayasmin.projetomc.domain.Pagamento;
import com.srayasmin.projetomc.domain.PagamentoComBoleto;
import com.srayasmin.projetomc.domain.PagamentoComCartao;
import com.srayasmin.projetomc.domain.Pedido;
import com.srayasmin.projetomc.domain.Produto;
import com.srayasmin.projetomc.domain.enums.EstadoPagamento;
import com.srayasmin.projetomc.domain.enums.TipoCliente;
import com.srayasmin.projetomc.repository.CategoriaRepository;
import com.srayasmin.projetomc.repository.CidadeRepository;
import com.srayasmin.projetomc.repository.ClienteRepository;
import com.srayasmin.projetomc.repository.EnderecoRepository;
import com.srayasmin.projetomc.repository.EstadoRepository;
import com.srayasmin.projetomc.repository.ItemPedidoRepository;
import com.srayasmin.projetomc.repository.PagamentoRepository;
import com.srayasmin.projetomc.repository.PedidoRepository;
import com.srayasmin.projetomc.repository.ProdutoRepository;


@SpringBootApplication
public class ProjetomcApplication implements CommandLineRunner{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    
    public static void main(String[] args) {
        SpringApplication.run(ProjetomcApplication.class, args);
    }

    @SuppressWarnings("null")
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

        // Criando os estados e cidades:
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        // Associando as cidades aos estados
        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        // Salvando os estados e cidades no banco de dados
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));


        // Cliente e endereço:
        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email", "777777", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("777777", "888888"));

        Cliente cli2 = new Cliente(null, "Ana Costa", "ana@gmail", "888888", TipoCliente.PESSOAFISICA);
        cli2.getTelefones().addAll(Arrays.asList("999999", "101010"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "157245", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "157246", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        // Salvando os clientes e endereços no banco de dados
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),null,cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),null,cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        // Salvando os pedidos e pagamentos no banco de dados
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        // Associando os produtos aos pedidos
        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        // Associando os itens de pedido aos pedidos
        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        // Associando os itens de pedido aos produtos
        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        // Salvando os itens de pedido no banco de dados
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        // Salvando os itens de pedido no banco de dados
        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}