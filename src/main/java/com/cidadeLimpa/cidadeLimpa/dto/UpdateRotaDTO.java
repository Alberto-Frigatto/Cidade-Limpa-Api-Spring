package com.cidadeLimpa.cidadeLimpa.dto;

import java.util.ArrayList;

public record UpdateRotaDTO(
    String horarioInicio,
    String horarioFim,
    ArrayList<String> listaPontosColeta,
    Long idRota
) {
}
