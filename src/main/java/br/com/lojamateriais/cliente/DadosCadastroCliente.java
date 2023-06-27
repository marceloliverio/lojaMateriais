package br.com.lojamateriais.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroCliente(

        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11,15}")
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone
        ){
}
