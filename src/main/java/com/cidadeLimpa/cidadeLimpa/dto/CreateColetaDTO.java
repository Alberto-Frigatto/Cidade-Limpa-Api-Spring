package com.cidadeLimpa.cidadeLimpa.dto;

import jakarta.validation.constraints.Min;

public record CreateColetaDTO(
    @Min(value = 1, message = "O id do caminhão deve ser maior ou igual a 1")
    Long idCaminhao,

    @Min(value = 1, message = "O id da lixeira deve ser maior ou igual a 1")
    Long idLixeira
)
{}
