package com.materiais.produto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
        @NotBlank
        String nomeProduto,
        @NotBlank
        int quantidade,
        @NotBlank
        double valor) {
}
