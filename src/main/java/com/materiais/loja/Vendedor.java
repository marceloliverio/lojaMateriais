package com.materiais.loja;

import com.materiais.vendedor.DadosCadastroVendedor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="vendedor")
@Entity(name="Vendedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int matricula;

    public Vendedor(DadosCadastroVendedor dados){

        this.nome = dados.nome();
        this.matricula = dados.matricula();
    }
}
