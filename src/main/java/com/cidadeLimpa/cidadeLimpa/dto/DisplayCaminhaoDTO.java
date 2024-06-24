package com.cidadeLimpa.cidadeLimpa.dto;

import com.cidadeLimpa.cidadeLimpa.model.Caminhao;
import com.cidadeLimpa.cidadeLimpa.model.Rota;

public record DisplayCaminhaoDTO(
    Long idCaminhao,
    String modelo,
    Integer capacidade,
    String placa,
    Rota rota
) {
    public DisplayCaminhaoDTO(Caminhao caminhao)
    {
        this(
            caminhao.getIdCaminhao(),
            caminhao.getModelo(),
            caminhao.getCapacidade(),
            caminhao.getPlaca(),
            caminhao.getRota()
        );
    }
}
