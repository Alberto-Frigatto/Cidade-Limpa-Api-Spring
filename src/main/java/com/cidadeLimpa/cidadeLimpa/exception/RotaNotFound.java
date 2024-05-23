package com.cidadeLimpa.cidadeLimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RotaNotFound extends RuntimeException {
    public RotaNotFound(Long id)
    {
        super("A Rota " + id + " não foi encontrada");
    }
}
