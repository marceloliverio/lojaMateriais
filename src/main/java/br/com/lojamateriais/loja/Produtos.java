package br.com.lojamateriais.loja;


import br.com.lojamateriais.produto.DadosAtualizacaoProduto;
import br.com.lojamateriais.produto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.*;

@Table(name="produto")
@Entity(name="produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String valor;

    private String quantidade;
    public Boolean ativo;

    public Produtos(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.quantidade = dados.quantidade();
        this.valor = dados.valor();
        this.ativo = true;

    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.quantidade() != null) {
            this.quantidade = dados.quantidade();
        }
    }

//    public void excluir() {
//        this.ativo = false;
//    }
}
