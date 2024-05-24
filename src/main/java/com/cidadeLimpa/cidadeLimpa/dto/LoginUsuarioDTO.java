package com.cidadeLimpa.cidadeLimpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUsuarioDTO(
    @NotBlank(message = "O email do usuário é obrigatório")
    @Email(message = "O email do usuário é inválido")
    String email,

    @NotBlank(message = "A senha do usuário é obrigatória")
    @Size(min = 8, message = "A senha do usuário deve ter pelo menos 8 caracteres")
    String senha
) {
}
