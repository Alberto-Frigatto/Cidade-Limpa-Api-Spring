package com.cidadeLimpa.cidadeLimpa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.repository.LixeiraRepository;
import com.cidadeLimpa.cidadeLimpa.dto.CreateLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateLixeiraDTO;
import com.cidadeLimpa.cidadeLimpa.exception.LixeiraNotFound;
import com.cidadeLimpa.cidadeLimpa.model.Lixeira;

@Service
public class LixeiraService {
    @Autowired
    private LixeiraRepository repository;

    public Page<DisplayLixeiraDTO> getAllLixeiras(Pageable pagination)
    {
        return repository
                    .findAll(pagination)
                    .map(lixeira -> new DisplayLixeiraDTO(lixeira));
    }

    public DisplayLixeiraDTO getLixeiraById(Long id)
    {
        Optional<Lixeira> lixeira = repository.findById(id);

        if (lixeira.isEmpty())
            throw new LixeiraNotFound(id);

        return new DisplayLixeiraDTO(lixeira.get());
    }

    public DisplayLixeiraDTO createLixeira(CreateLixeiraDTO createLixeiraDTO)
    {
        Lixeira lixeira = new Lixeira();

        BeanUtils.copyProperties(createLixeiraDTO, lixeira);

        Lixeira lixeiraSalva = repository.save(lixeira);

        return new DisplayLixeiraDTO(lixeiraSalva);
    }

    public void deleteLixeira(Long id)
    {
        DisplayLixeiraDTO lixeiraDTO = this.getLixeiraById(id);
        Lixeira lixeira = new Lixeira();

        BeanUtils.copyProperties(lixeiraDTO, lixeira);

        repository.delete(lixeira);
    }

    public DisplayLixeiraDTO updateLixeira(UpdateLixeiraDTO updateLixeiraDTO)
    {
        this.getLixeiraById(updateLixeiraDTO.idLixeira());

        Lixeira lixeira = new Lixeira();

        BeanUtils.copyProperties(updateLixeiraDTO, lixeira);

        Lixeira lixeiraSalva = repository.save(lixeira);

        return new DisplayLixeiraDTO(lixeiraSalva);
    }

    public List<DisplayLixeiraDTO> searchLixeiraByLocalizacao(String localizacao)
    {
        return repository
                    .findByLocalizacao("%" + localizacao + "%")
                    .stream()
                    .map(DisplayLixeiraDTO::new)
                    .toList();
    }

    public List<DisplayLixeiraDTO> searchLixeiraByCapacidade(Integer minCapacidade, Integer maxCapacidade)
    {
        return repository
                    .findByCapacidade(minCapacidade, maxCapacidade)
                    .stream()
                    .map(DisplayLixeiraDTO::new)
                    .toList();
    }

    public List<DisplayLixeiraDTO> searchLixeiraByOcupacao(BigDecimal minOcupacao, BigDecimal maxOcupacao)
    {
        return repository
                    .findByOcupacao(minOcupacao, maxOcupacao)
                    .stream()
                    .map(DisplayLixeiraDTO::new)
                    .toList();
    }
}
