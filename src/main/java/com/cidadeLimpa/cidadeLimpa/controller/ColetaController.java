package com.cidadeLimpa.cidadeLimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cidadeLimpa.cidadeLimpa.dto.CreateColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayColetaDTO;
import com.cidadeLimpa.cidadeLimpa.service.ColetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coletas")
public class ColetaController
{
    @Autowired
    private ColetaService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<DisplayColetaDTO> getAllColetas(Pageable pagination)
    {
        return service.getAllColetas(pagination);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisplayColetaDTO getColetaById(@PathVariable Long id)
    {
        return service.getColetaById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DisplayColetaDTO createColeta(@Valid @RequestBody CreateColetaDTO coleta)
    {
        return service.createColeta(coleta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCaminhao(@PathVariable Long id)
    {
        service.deleteColeta(id);
    }

    @GetMapping(value = "", params = "idCaminhao")
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayColetaDTO> searchColetaByIdCaminhao(@RequestParam Long idCaminhao)
    {
        return service.searchColetaByIdCaminhao(idCaminhao);
    }

    @GetMapping(value = "", params = "idLixeira")
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayColetaDTO> searchColetaByIdLixeira(@RequestParam Long idLixeira)
    {
        return service.searchColetaByIdLixeira(idLixeira);
    }

    @GetMapping(value = "", params = "data")
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayColetaDTO> searchColetaByData(@RequestParam String data)
    {
        return service.searchColetaByData(data);
    }
}
