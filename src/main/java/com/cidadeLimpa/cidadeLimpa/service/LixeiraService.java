package com.cidadeLimpa.cidadeLimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.repository.LixeiraRepository;
import com.cidadeLimpa.cidadeLimpa.model.Lixeira;

@Service
public class LixeiraService {
    @Autowired
    private LixeiraRepository repository;

    public List<Lixeira> getAllLixeiras()
    {
        return repository.findAll();
    }

    public Lixeira getLixeiraById(Long id)
    {
        Optional<Lixeira> lixeira = repository.findById(id);

        if (lixeira.isEmpty())
        {
            String message = "A lixeira " + id + " não existe";

            throw new RuntimeException(message);
        }

        return lixeira.get();
    }

    public Lixeira createLixeira(Lixeira lixeira)
    {
        return repository.save(lixeira);
    }

    public void deleteLixeira(Long id)
    {
        Lixeira lixeira = this.getLixeiraById(id);

        repository.delete(lixeira);
    }

    public Lixeira updateLixeira(Lixeira lixeira)
    {
        this.getLixeiraById(lixeira.getIdLixeira());

        return repository.save(lixeira);
    }
}
