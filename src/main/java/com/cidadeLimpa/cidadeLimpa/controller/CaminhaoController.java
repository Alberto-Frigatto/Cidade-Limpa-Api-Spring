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

import com.cidadeLimpa.cidadeLimpa.dto.CreateCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.service.CaminhaoService;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController
{
    @Autowired
    private CaminhaoService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<DisplayCaminhaoDTO> getAllCaminhoes()
    {
        return service.getAllCaminhoes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisplayCaminhaoDTO getCaminhaoById(@PathVariable Long id)
    {
        return service.getCaminhaoById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DisplayCaminhaoDTO createCaminhao(@RequestBody CreateCaminhaoDTO caminhao)
    {
        return service.createCaminhao(caminhao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCaminhao(@PathVariable Long id)
    {
        service.deleteCaminhao(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public DisplayCaminhaoDTO updateCaminhao(@RequestBody UpdateCaminhaoDTO caminhao)
    {
        return service.updateCaminhao(caminhao);
    }
}
