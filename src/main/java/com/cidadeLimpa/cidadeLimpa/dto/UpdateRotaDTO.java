package com.cidadeLimpa.cidadeLimpa.dto;

import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UpdateRotaDTO(
    @NotBlank(message = "O horário de início da rota é obrigatório")
    @Size(min = 5, max = 5, message = "O horário de início da rota deve estar no formato HH:MM")
    String horarioInicio,

    @NotBlank(message = "O horário de fim da rota é obrigatório")
    @Size(min = 5, max = 5, message = "O horário de fim da rota deve estar no formato HH:MM")
    String horarioFim,

    @NotEmpty(message = "A lista de pontos de coleta da rota é obrigatória")
    ArrayList<String> listaPontosColeta,

    @NotBlank(message = "O id da rota é obrigatório")
    Long idRota
) {
}
