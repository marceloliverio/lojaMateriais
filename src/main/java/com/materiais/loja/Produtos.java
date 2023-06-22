package com.materiais.loja;


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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoProduto;
    private double valor;
    private int quantidade;
}
