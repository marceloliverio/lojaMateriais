package br.com.lojamateriais.vendas;

import br.com.lojamateriais.loja.Cliente;
import br.com.lojamateriais.loja.Produtos;
import br.com.lojamateriais.loja.Vendedor;

import java.util.List;

public record DadosListagemVendas(Cliente cliente,List<Produtos> produtos, Vendedor vendedor) {

}
