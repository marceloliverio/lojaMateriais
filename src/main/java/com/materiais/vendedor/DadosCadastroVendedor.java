package com.materiais.vendedor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVendedor(
        @NotBlank
        String nome,
        @NotBlank
        int matricula) {
}
