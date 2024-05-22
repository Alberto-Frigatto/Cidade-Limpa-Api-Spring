package com.cidadeLimpa.cidadeLimpa.dto;

public record CreateCaminhaoDTO(
    String modelo,
    Integer capacidade,
    String placa,
    Long idRota
) {
}
