package br.com.lojamateriais.controllers;

import br.com.lojamateriais.cliente.ClienteRepository;
import br.com.lojamateriais.cliente.DadosAtualizacaoCliente;
import br.com.lojamateriais.cliente.DadosCadastroCliente;
import br.com.lojamateriais.cliente.DadosListagemCliente;
import br.com.lojamateriais.loja.Cliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados){

        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
    }

}
