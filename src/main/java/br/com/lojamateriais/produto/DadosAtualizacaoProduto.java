package br.com.lojamateriais.produto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoProduto(
        @NotBlank
        Long id,
        String nome,
        String valor,
        String quantidade
) {
}
