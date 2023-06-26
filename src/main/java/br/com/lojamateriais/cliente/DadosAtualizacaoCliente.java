package br.com.lojamateriais.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoCliente(
        @NotBlank
        Long id,
        String nome,
        String cpf,
        String email,
        Long telefone
) {
}
// nem todos os valores são de preenchimento obrigatório pois somente um dado pode ser alterado. O único obrigatório é o ID para informar qual cliente será alterado