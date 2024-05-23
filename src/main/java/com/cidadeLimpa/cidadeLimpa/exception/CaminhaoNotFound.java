package com.cidadeLimpa.cidadeLimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CaminhaoNotFound extends RuntimeException {
    public CaminhaoNotFound(Long id)
    {
        super("O caminhão " + id + " não foi encontrado");
    }
}
