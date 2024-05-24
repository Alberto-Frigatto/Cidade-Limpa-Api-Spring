package com.cidadeLimpa.cidadeLimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cidadeLimpa.cidadeLimpa.dto.CreateLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DIsplayLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.service.LixeiraParaColetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lixeirasParaColeta")
public class LixeiraParaColetaController {
    @Autowired
    private LixeiraParaColetaService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<DIsplayLixeiraParaColetaDTO> getAllLixeiraParaColeta(Pageable pagination)
    {
        return service.getAllLixeirasParaColeta(pagination);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DIsplayLixeiraParaColetaDTO getLixeiraParaColetaById(@PathVariable Long id)
    {
        return service.getLixeiraParaColetaById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DIsplayLixeiraParaColetaDTO createLixeiraParaColeta(@Valid @RequestBody CreateLixeiraParaColetaDTO lixeira)
    {
        return service.createLixeiraParaColeta(lixeira);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLixeira(@PathVariable Long id)
    {
        service.deleteLixeiraParaColeta(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DIsplayLixeiraParaColetaDTO updateLixeiraParaColeta(@Valid @RequestBody UpdateLixeiraParaColetaDTO lixeira)
    {
        return service.updateLixeiraParaColeta(lixeira);
    }

    @GetMapping(value = "", params = "ativo")
    @ResponseStatus(HttpStatus.OK)
    public List<DIsplayLixeiraParaColetaDTO> searchLixeiraParaColetaByAtivo(@RequestParam boolean ativo)
    {
        return service.searchLixeiraParaColetaByAtivo(ativo);
    }

    @GetMapping(value = "", params = "idLixeira")
    @ResponseStatus(HttpStatus.OK)
    public List<DIsplayLixeiraParaColetaDTO> searchLixeiraParaColetaByIdLixeira(@RequestParam Long idLixeira)
    {
        return service.searchLixeiraParaColetaByIdLixeira(idLixeira);
    }
}
