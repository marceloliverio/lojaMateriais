package br.com.lojamateriais.produto;

import br.com.lojamateriais.loja.Produtos;

public record DadosListagemProduto(Long id, String nome, String valor, String quantidade) {
    public DadosListagemProduto(Produtos produto){
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getQuantidade());
    }
}
