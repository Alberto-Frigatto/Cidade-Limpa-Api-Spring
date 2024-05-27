package com.cidadeLimpa.cidadeLimpa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cidadeLimpa.cidadeLimpa.config.security.TokenService;
import com.cidadeLimpa.cidadeLimpa.dto.CreateUsuarioDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayTokenDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayUsuarioDTO;
import com.cidadeLimpa.cidadeLimpa.dto.LoginUsuarioDTO;
import com.cidadeLimpa.cidadeLimpa.model.Usuario;
import com.cidadeLimpa.cidadeLimpa.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService service;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public DisplayTokenDTO login(
            @RequestBody
            @Valid
            LoginUsuarioDTO usuarioDTO
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDTO.email(),
                        usuarioDTO.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.createToken((Usuario) auth.getPrincipal());

        return new DisplayTokenDTO(token);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public DisplayUsuarioDTO registrar(@RequestBody @Valid CreateUsuarioDTO usuario){
        return service.createUsuario(usuario);
    }
}
