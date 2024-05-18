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

import com.cidadeLimpa.cidadeLimpa.model.Lixeira;
import com.cidadeLimpa.cidadeLimpa.service.LixeiraService;

@RestController
@RequestMapping("/lixeiras")
public class LixeiraController {
    @Autowired
    private LixeiraService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Lixeira> getAllLixeiras()
    {
        return service.getAllLixeiras();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lixeira getLixeiraById(@PathVariable Long id)
    {
        return service.getLixeiraById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Lixeira createLixeira(@RequestBody Lixeira lixeira)
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
    public Lixeira updateLixeira(@RequestBody Lixeira lixeira)
    {
        return service.updateLixeira(lixeira);
    }
}
