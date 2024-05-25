package com.cidadeLimpa.cidadeLimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LixeiraNotFound extends RuntimeException
{
    public LixeiraNotFound(Long id)
    {
        super("A lixeira " + id + " não existe");
    }

}
