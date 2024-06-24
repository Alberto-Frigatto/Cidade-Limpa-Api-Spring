package com.cidadeLimpa.cidadeLimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ColetaNotFound extends RuntimeException
{
    public ColetaNotFound(Long id)
    {
        super("A coleta " + id + " não existe");
    }
}
