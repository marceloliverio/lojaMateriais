package br.com.lojamateriais.vendedor;

import jakarta.validation.constraints.NotBlank;
//beeeeh
public record DadosCadastroVendedor(
        @NotBlank
        String nome,
        @NotBlank
        String matricula) {
}
