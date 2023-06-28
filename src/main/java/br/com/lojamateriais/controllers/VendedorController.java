package br.com.lojamateriais.controllers;

import br.com.lojamateriais.loja.Vendedor;
import br.com.lojamateriais.vendedor.DadosAtualizacaoVendedor;
import br.com.lojamateriais.vendedor.DadosCadastroVendedor;
import br.com.lojamateriais.vendedor.DadosListagemVendedor;
import br.com.lojamateriais.vendedor.VendedorRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorRepository repository;


    @PostMapping
    @Transactional
    public void cadastrarVendedor(@RequestBody DadosCadastroVendedor dados){
        repository.save(new Vendedor(dados));
    }

    @GetMapping
    public Page<DadosListagemVendedor> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findByAtivoTrue(paginacao).map(DadosListagemVendedor::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoVendedor dados) {
        var vendedor = repository.getReferenceById(dados.id());
        vendedor.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var vendedor = repository.getReferenceById(id);
        vendedor.desativar();

    }
}
