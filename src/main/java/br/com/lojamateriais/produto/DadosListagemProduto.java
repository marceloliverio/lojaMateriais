package br.com.lojamateriais.produto;

import br.com.lojamateriais.loja.Produtos;

public record DadosListagemProduto(Long id, String nomeProduto, double valor, int quantidade) {
    public DadosListagemProduto(Produtos produto){
        this(produto.getId(), produto.getNomeProduto(), produto.getValor(), produto.getQuantidade());
    }
}
