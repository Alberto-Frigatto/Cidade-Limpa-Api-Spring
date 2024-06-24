package com.cidadeLimpa.cidadeLimpa.dto;

import com.cidadeLimpa.cidadeLimpa.model.Usuario;

public record DisplayUsuarioDTO(
    Long idUsuario,
    String email
) {
    public DisplayUsuarioDTO(Usuario usuario)
    {
        this(
            usuario.getIdUsuario(),
            usuario.getEmail()
        );
    }
}
