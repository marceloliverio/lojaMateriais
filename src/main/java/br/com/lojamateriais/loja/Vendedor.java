package br.com.lojamateriais.loja;

import br.com.lojamateriais.vendedor.DadosAtualizacaoVendedor;
import br.com.lojamateriais.vendedor.DadosCadastroVendedor;
import jakarta.persistence.*;
import lombok.*;


@Table(name="vendedor")
@Entity(name="vendedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String matricula;

    private boolean ativo;

    public Vendedor(DadosCadastroVendedor dados){

        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoVendedor dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.matricula() != null){
            this.matricula = dados.matricula();
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
