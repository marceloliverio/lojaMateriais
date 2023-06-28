package br.com.lojamateriais.vendedor;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoVendedor(
        @NotBlank
        Long id,

        String nome,

        String matricula
) {
}
