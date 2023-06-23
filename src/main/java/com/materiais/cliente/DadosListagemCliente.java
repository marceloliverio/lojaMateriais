package com.materiais.cliente;

import com.materiais.loja.Cliente;

public record DadosListagemCliente(Long id, String nome, String cpf, String email, Long telefone) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(),cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
    }
}
