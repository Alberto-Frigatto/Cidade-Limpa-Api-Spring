package com.cidadeLimpa.cidadeLimpa.dto;

import java.util.ArrayList;

import com.cidadeLimpa.cidadeLimpa.model.Rota;

public record DisplayRotaDTO(
    Long idRota,
    String horarioInicio,
    String horarioFim,
    ArrayList<String> listaPontosColeta
) {
    public DisplayRotaDTO(Rota rota)
    {
        this(
            rota.getIdRota(),
            rota.getHorarioInicio(),
            rota.getHorarioFim(),
            rota.getListaPontosColeta()
        );
    }
}

