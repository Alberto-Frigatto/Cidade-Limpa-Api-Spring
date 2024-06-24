package com.cidadeLimpa.cidadeLimpa.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cidadeLimpa.cidadeLimpa.model.Usuario;

@Service
public class TokenService {
    @Value("minha.chave.secreta")
    private String palavraSecreta;

    public String createToken(Usuario usuario) throws RuntimeException
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(this.palavraSecreta);

            String token = JWT.create()
                .withIssuer("cidadeLimpa")
                .withSubject(usuario.getEmail())
                .withExpiresAt(this.createExpDate())
                .sign(algorithm);

            return token;
        }
        catch (JWTCreationException e)
        {
            throw new RuntimeException("Não foi possível criar o token");
        }
    }

    private Instant createExpDate()
    {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validarToken(String token){
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(this.palavraSecreta);

            return JWT.require(algorithm)
                    .withIssuer("cidadeLimpa")
                    .build()
                    .verify(token)
                    .getSubject();

        }
        catch (JWTVerificationException e)
        {
            return "";
        }
    }
}
