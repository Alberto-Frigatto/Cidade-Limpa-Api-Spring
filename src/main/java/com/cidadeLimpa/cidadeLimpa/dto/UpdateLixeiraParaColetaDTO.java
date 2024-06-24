package com.cidadeLimpa.cidadeLimpa.dto;

import jakarta.validation.constraints.Min;

public record UpdateLixeiraParaColetaDTO(
    @Min(value = 1, message = "O id da lixeira deve ser maior ou igual a 1")
    Long idLixeiraParaColeta,

    boolean ativo
) {

}
