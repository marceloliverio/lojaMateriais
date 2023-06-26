package br.com.lojamateriais.loja;


import br.com.lojamateriais.produto.DadosAtualizacaoProduto;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="produtos")
@Entity(name="Produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private double valor;

    private int quantidade;
    public Boolean ativo = true;

    public Produtos(DadosCadastroProduto dados) {
        this.nomeProduto = dados.nomeProduto();
        this.quantidade = dados.quantidade();
        this.valor = dados.valor();

    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if (dados.nomeProduto() != null) {
            this.nomeProduto = dados.nomeProduto();
        }
        if (dados.valor() != 0) {
            this.valor = dados.valor();
        }
        if (dados.quantidade() != 0) {
            this.quantidade = dados.quantidade();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
