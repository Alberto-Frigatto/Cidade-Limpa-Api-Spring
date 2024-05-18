package com.cidadeLimpa.cidadeLimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cidadeLimpa.cidadeLimpa.model.Rota;
import com.cidadeLimpa.cidadeLimpa.service.RotaService;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    @Autowired
    private RotaService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Rota> getAllRotas()
    {
        return service.getAllRotas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Rota getRotaById(@PathVariable Long id)
    {
        return service.getRotaById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Rota createRota(@RequestBody Rota rota)
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
    public Rota updateRota(@RequestBody Rota rota)
    {
        return service.updateRota(rota);
    }
}
