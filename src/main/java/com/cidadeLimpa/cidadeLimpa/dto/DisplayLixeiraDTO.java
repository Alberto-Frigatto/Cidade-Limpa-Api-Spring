package com.cidadeLimpa.cidadeLimpa.dto;

import java.math.BigDecimal;

import com.cidadeLimpa.cidadeLimpa.model.Lixeira;

public record DisplayLixeiraDTO (
    Long idLixeira,
    String localizacao,
    Integer capacidade,
    BigDecimal ocupacao
)
{
    public DisplayLixeiraDTO(Lixeira lixeira)
    {
        this(
            lixeira.getIdLixeira(),
            lixeira.getLocalizacao(),
            lixeira.getCapacidade(),
            lixeira.getOcupacao()
        );
    }
}
