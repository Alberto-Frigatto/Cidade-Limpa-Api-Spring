package com.cidadeLimpa.cidadeLimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.dto.CreateRotaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayRotaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateRotaDTO;
import com.cidadeLimpa.cidadeLimpa.model.Rota;
import com.cidadeLimpa.cidadeLimpa.repository.RotaRepository;

@Service
public class RotaService {
    @Autowired
    private RotaRepository repository;

    public List<DisplayRotaDTO> getAllRotas()
    {
        return repository
                    .findAll()
                    .stream()
                    .map(DisplayRotaDTO::new)
                    .toList();
    }

    public DisplayRotaDTO getRotaById(Long id)
    {
        Optional<Rota> rota = repository.findById(id);

        if (rota.isEmpty())
            throw new RotaNotFound(id);

        return new DisplayRotaDTO(rota.get());
    }

    public DisplayRotaDTO createRota(CreateRotaDTO createRotaDTO)
    {
        Rota rota = new Rota();

        BeanUtils.copyProperties(createRotaDTO, rota);

        Rota rotaSalva = repository.save(rota);

        return new DisplayRotaDTO(rotaSalva);
    }

    public void deleteRota(Long id)
    {
        DisplayRotaDTO rotaDTO = this.getRotaById(id);
        Rota rota = new Rota();

        BeanUtils.copyProperties(rotaDTO, rota);

        repository.delete(rota);
    }

    public DisplayRotaDTO updateRota(UpdateRotaDTO updateRotaDTO)
    {
        Rota rota = new Rota();

        BeanUtils.copyProperties(updateRotaDTO, rota);

        Rota rotaSalva = repository.save(rota);

        return new DisplayRotaDTO(rotaSalva);
    }
}
