package com.InventoFlex.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record FornecedorDTO(
        String nome,
        String cnpj,
        String cep,
        String estado,
        String municipio,
        String logradouro,
        String numero
        ) {
}
