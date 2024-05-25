package com.cidadeLimpa.cidadeLimpa.dto;

import com.cidadeLimpa.cidadeLimpa.model.Caminhao;
import com.cidadeLimpa.cidadeLimpa.model.Coleta;
import com.cidadeLimpa.cidadeLimpa.model.Lixeira;

public record DisplayColetaDTO(
    Long idColeta,
    Caminhao caminhao,
    Lixeira lixeira,
    String data
) {
    public DisplayColetaDTO(Coleta coleta)
    {
        this(
            coleta.getIdColeta(),
            coleta.getCaminhao(),
            coleta.getLixeira(),
            coleta.getData()
        );
    }
}
