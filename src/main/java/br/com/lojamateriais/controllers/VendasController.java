//package br.com.lojamateriais.controllers;
//
//import br.com.lojamateriais.cliente.ClienteRepository;
//import br.com.lojamateriais.loja.Cliente;
//import br.com.lojamateriais.loja.Produtos;
//import br.com.lojamateriais.produto.DadosCadastroProduto;
//import br.com.lojamateriais.produto.ProdutoRepository;
//import br.com.lojamateriais.vendas.DadosCadastroVendas;
//import br.com.lojamateriais.vendas.DadosListagemVendas;
//import br.com.lojamateriais.vendas.Vendas;
//import br.com.lojamateriais.vendas.VendasRepository;
//import br.com.lojamateriais.vendedor.VendedorRepository;
//import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.function.Function;
//
//@RestController
//@RequestMapping ("/vendas")
//
//public class VendasController {
//    @Autowired
//    private VendasRepository repository;
//
//    @Autowired
//    private ClienteRepository cRepository;
//
//    @Autowired
//    private VendedorRepository vRepository;
//
//    @Autowired
//    private ProdutoRepository pRepository;
//
////    @PostMapping
////    @Transactional
////    public void cadastrarVendas(Long idCliente, Long idVendedor, List<Produtos> produtos){
////
////       var cliente = cRepository.getReferenceById(idCliente);
////       var vendedor = vRepository.getReferenceById(idVendedor);
////       List
////        repository.save();
////
////    }
////    @GetMapping
////    public Page listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
////        return repository.findByFinalizadaTrue(paginacao).map((Function<? super Vendas, ? extends DadosListagemVendas>) DadosListagemVendas::new);
////    }
//
//
//}
