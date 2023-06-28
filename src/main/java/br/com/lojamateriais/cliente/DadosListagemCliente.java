package br.com.lojamateriais.cliente;

import br.com.lojamateriais.loja.Cliente;
import br.com.lojamateriais.loja.Produtos;

public record DadosListagemCliente(Long id, String nome, String cpf, String email, String telefone) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(),cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
    }
}
