package com.cidadeLimpa.cidadeLimpa.dto;

import java.util.Date;

import com.cidadeLimpa.cidadeLimpa.model.Lixeira;
import com.cidadeLimpa.cidadeLimpa.model.LixeiraParaColeta;

public record DIsplayLixeiraParaColetaDTO(
    Long idLixeiraParaColeta,
    Date dataSolicitacao,
    Date dataLimite,
    Boolean ativo,
    Lixeira lixeira
) {
    public DIsplayLixeiraParaColetaDTO(LixeiraParaColeta lixeiraParaColeta)
    {
        this(
            lixeiraParaColeta.getIdLixeiraParaColeta(),
            lixeiraParaColeta.getDataSolicitacao(),
            lixeiraParaColeta.getDataLimite(),
            lixeiraParaColeta.getAtivo(),
            lixeiraParaColeta.getLixeira()
        );
    }
}
