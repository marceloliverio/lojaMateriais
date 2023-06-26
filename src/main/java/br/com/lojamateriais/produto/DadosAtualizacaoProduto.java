package br.com.lojamateriais.produto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoProduto(
        @NotBlank
        Long id,
        String nomeProduto,
        double valor,
        int quantidade
) {
}
