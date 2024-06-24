package com.cidadeLimpa.cidadeLimpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cidadeLimpa.cidadeLimpa.dto.CreateRotaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayRotaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateRotaDTO;
import com.cidadeLimpa.cidadeLimpa.service.RotaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    @Autowired
    private RotaService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<DisplayRotaDTO> getAllRotas(Pageable pagination)
    {
        return service.getAllRotas(pagination);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisplayRotaDTO getRotaById(@PathVariable Long id)
    {
        return service.getRotaById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DisplayRotaDTO createRota(@Valid @RequestBody CreateRotaDTO rota)
    {
        return service.createRota(rota);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRota(@PathVariable Long id)
    {
        service.deleteRota(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DisplayRotaDTO updateRota(@Valid @RequestBody UpdateRotaDTO rota)
    {
        return service.updateRota(rota);
    }
}
