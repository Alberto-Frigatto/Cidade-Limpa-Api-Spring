package com.cidadeLimpa.cidadeLimpa.dto;

public record UpdateCaminhaoDTO(
    String modelo,
    Integer capacidade,
    String placa,
    Long idRota
) {
}
