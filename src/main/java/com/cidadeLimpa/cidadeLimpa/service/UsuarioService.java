package com.cidadeLimpa.cidadeLimpa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.dto.CreateUsuarioDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayUsuarioDTO;
import com.cidadeLimpa.cidadeLimpa.model.Usuario;
import com.cidadeLimpa.cidadeLimpa.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public DisplayUsuarioDTO createUsuario(CreateUsuarioDTO createUsuarioDTO)
    {
        String passwordHash = new BCryptPasswordEncoder().encode(createUsuarioDTO.senha());

        Usuario usuario = new Usuario();

        BeanUtils.copyProperties(createUsuarioDTO, usuario);
        usuario.setSenha(passwordHash);

        Usuario usuarioSalvo = repository.save(usuario);

        return new DisplayUsuarioDTO(usuarioSalvo);
    }
}
