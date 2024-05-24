package com.cidadeLimpa.cidadeLimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LixeiraParaColetaNotFound extends RuntimeException {
    public LixeiraParaColetaNotFound(Long id)
    {
        super("A lixeira para coleta " + id + " não foi encontrada");
    }
}
