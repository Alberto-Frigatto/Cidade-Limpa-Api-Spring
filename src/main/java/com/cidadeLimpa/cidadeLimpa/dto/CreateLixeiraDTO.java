package com.cidadeLimpa.cidadeLimpa.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateLixeiraDTO(
    @NotBlank(message = "A localização da lixeira é obrigatória")
    @Size(min = 1, max = 100, message = "A localização deve ter no máximo 100 caracteres")
    String localizacao,

    Integer capacidade,

    @DecimalMin(value = "0.00", inclusive = true, message = "O percentual deve ser maior ou igual a 0.00")
    @DecimalMax(value = "1.00", inclusive = true, message = "O percentual deve ser menor ou igual a 1.00")
    @Digits(integer = 1, fraction = 2, message = "O percentual deve ter no máximo 1 dígito inteiro e 2 dígitos decimais")
    BigDecimal ocupacao
)
{
}
