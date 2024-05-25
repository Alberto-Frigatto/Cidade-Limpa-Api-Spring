package com.cidadeLimpa.cidadeLimpa.controller;

import java.math.BigDecimal;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cidadeLimpa.cidadeLimpa.dto.CreateLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.service.LixeiraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lixeiras")
public class LixeiraController {
    @Autowired
    private LixeiraService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<DisplayLixeiraDTO> getAllLixeiras(Pageable pagination)
    {
        return service.getAllLixeiras(pagination);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisplayLixeiraDTO getLixeiraById(@PathVariable Long id)
    {
        return service.getLixeiraById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DisplayLixeiraDTO createLixeira(@Valid @RequestBody CreateLixeiraDTO lixeira)
    {
        return service.createLixeira(lixeira);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLixeira(@PathVariable Long id)
    {
        service.deleteLixeira(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DisplayLixeiraDTO updateLixeira(@Valid @RequestBody UpdateLixeiraDTO lixeira)
    {
        return service.updateLixeira(lixeira);
    }

    @GetMapping(value = "", params = "localizacao")
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayLixeiraDTO> searchLixeiraByLocalizacao(@RequestParam String localizacao)
    {
        return service.searchLixeiraByLocalizacao(localizacao);
    }

    @GetMapping(value = "", params = {"minCapacidade", "maxCapacidade"})
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayLixeiraDTO> searchLixeiraByCapacidade(@RequestParam Integer minCapacidade, @RequestParam Integer maxCapacidade)
    {
        return service.searchLixeiraByCapacidade(minCapacidade, maxCapacidade);
    }

    @GetMapping(value = "", params = {"minOcupacao", "maxOcupacao"})
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayLixeiraDTO> searchLixeiraByOcupacao(@RequestParam BigDecimal minOcupacao, @RequestParam BigDecimal maxOcupacao)
    {
        return service.searchLixeiraByOcupacao(minOcupacao, maxOcupacao);
    }
}
