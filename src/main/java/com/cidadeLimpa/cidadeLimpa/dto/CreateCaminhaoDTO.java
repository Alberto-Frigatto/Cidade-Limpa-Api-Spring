package com.cidadeLimpa.cidadeLimpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCaminhaoDTO(
    @NotBlank(message = "O modelo do caminhão é obrigatório")
    @Size(min = 1, max = 50, message = "O modelo do caminhão deve ter no máximo 50 caracteres")
    String modelo,

    @NotBlank(message = "A capacidade do caminhão é obrigatório")
    Integer capacidade,

    @NotBlank(message = "A placa do caminhão é obrigatório")
    @Size(min = 7, max = 7, message = "A placa do caminhão deve ter 7 caracteres")
    String placa,

    @NotBlank(message = "O id da rota do caminhão é obrigatório")
    Long idRota
) {
}
