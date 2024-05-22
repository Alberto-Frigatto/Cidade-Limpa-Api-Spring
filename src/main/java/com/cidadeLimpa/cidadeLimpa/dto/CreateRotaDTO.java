package com.cidadeLimpa.cidadeLimpa.dto;

import java.util.ArrayList;

public record CreateRotaDTO(
    String horarioInicio,
    String horarioFim,
    ArrayList<String> listaPontosColeta
) {
}
