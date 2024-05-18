package com.cidadeLimpa.cidadeLimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.model.Rota;
import com.cidadeLimpa.cidadeLimpa.repository.RotaRepository;

@Service
public class RotaService {
    @Autowired
    private RotaRepository repository;

    public List<Rota> getAllRotas()
    {
        return repository.findAll();
    }

    public Rota getRotaById(Long id)
    {
        Optional<Rota> rota = repository.findById(id);

        if (rota.isEmpty())
        {
            String message = "A rota " + id + " não existe";

            throw new RuntimeException(message);
        }

        return rota.get();
    }

    public Rota createRota(Rota rota)
    {
        return repository.save(rota);
    }

    public void deleteRota(Long id)
    {
        Rota rota = this.getRotaById(id);

        repository.delete(rota);
    }

    public Rota updateRota(Rota rota)
    {
        this.getRotaById(rota.getIdRota());

        return repository.save(rota);
    }
}
