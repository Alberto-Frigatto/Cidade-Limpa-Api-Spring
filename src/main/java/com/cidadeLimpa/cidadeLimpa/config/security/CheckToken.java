package com.cidadeLimpa.cidadeLimpa.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cidadeLimpa.cidadeLimpa.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CheckToken extends OncePerRequestFilter {
    @Autowired
    private TokenService service;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("AUthorization");
        String token;

        if (authorizationHeader != null)
        {
            token = authorizationHeader.replace("Bearer", "").trim();
            String login = service.validarToken(token);
            UserDetails usuario = repository.findByEmail(login);

            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                    usuario,
                    null,
                    usuario.getAuthorities()
                );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else
        {
            token = null;
        }

        filterChain.doFilter(request, response);
    }
}
