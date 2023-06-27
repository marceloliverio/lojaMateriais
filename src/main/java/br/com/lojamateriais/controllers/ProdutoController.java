package br.com.lojamateriais.controllers;

import br.com.lojamateriais.cliente.DadosAtualizacaoCliente;
import br.com.lojamateriais.cliente.DadosListagemCliente;
import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import br.com.lojamateriais.produto.DadosAtualizacaoProduto;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import br.com.lojamateriais.produto.DadosListagemProduto;
import br.com.lojamateriais.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados){
        repository.save(new Produtos(dados));
    }

//    @GetMapping
//    public Page<DadosListagemProduto>listar(@PageableDefault (size = 10, sort = {"nomeProduto"}) Pageable paginacao){
//        return repository.findById(paginacao).map(DadosListagemProduto::new);
//    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados){
        var produtos = repository.getReferenceById(dados.id());
        produtos.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var produtos = repository.getReferenceById(id);
        produtos.excluir();
    }

}
