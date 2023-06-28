package br.com.lojamateriais.vendedor;

import br.com.lojamateriais.loja.Vendedor;

public record DadosListagemVendedor(Long id, String nome, String matricula) {

    public DadosListagemVendedor(Vendedor vendedor){
        this(vendedor.getId(), vendedor.getNome(), vendedor.getMatricula());
    }
}
