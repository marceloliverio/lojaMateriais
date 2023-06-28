package br.com.lojamateriais.produto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
        @NotBlank
        String nome,

        String quantidade,

        String valor) {
}
