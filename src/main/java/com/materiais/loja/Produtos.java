package com.materiais.loja;


import com.materiais.cliente.DadosCadastroCliente;
import com.materiais.produto.DadosCadastroProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private double valor;

    private int quantidade;

    public Produtos (DadosCadastroProduto dados){
        this.nomeProduto = dados.nomeProduto();
        this.quantidade = dados.quantidade();
        this.valor = dados.valor();

    }
}
