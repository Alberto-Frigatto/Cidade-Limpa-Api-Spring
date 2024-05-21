package com.cidadeLimpa.cidadeLimpa.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.dto.CreateLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DIsplayLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateLixeiraParaColetaDTO;
import com.cidadeLimpa.cidadeLimpa.model.Lixeira;
import com.cidadeLimpa.cidadeLimpa.model.LixeiraParaColeta;
import com.cidadeLimpa.cidadeLimpa.repository.LixeiraParaColetaRepository;
import com.cidadeLimpa.cidadeLimpa.repository.LixeiraRepository;

@Service
public class LixeiraParaColetaService {
    @Autowired
    private LixeiraParaColetaRepository lixeiraParaColetaRepository;

    @Autowired
    private LixeiraRepository lixeiraRepository;

    public List<DIsplayLixeiraParaColetaDTO> getAllLixeirasParaColeta()
    {
        return lixeiraParaColetaRepository
                    .findAll()
                    .stream()
                    .map(DIsplayLixeiraParaColetaDTO::new)
                    .toList();
    }

    public DIsplayLixeiraParaColetaDTO getLixeiraParaColetaById(Long id)
    {
        Optional<LixeiraParaColeta> lixeiraParaColeta = lixeiraParaColetaRepository.findById(id);

        if (lixeiraParaColeta.isEmpty())
        {
            String message = "A lixeira para coleta " + id + " não existe";

            throw new RuntimeException(message);
        }

        return new DIsplayLixeiraParaColetaDTO(lixeiraParaColeta.get());
    }

    public DIsplayLixeiraParaColetaDTO createLixeiraParaColeta(CreateLixeiraParaColetaDTO createLixeiraParaColetaDTO)
    {
        Lixeira lixeira = this.getLixeiraById(createLixeiraParaColetaDTO.idLixeira());
        LixeiraParaColeta lixeiraParaColeta = new LixeiraParaColeta();

        lixeiraParaColeta.setLixeira(lixeira);
        lixeiraParaColeta.setAtivo(true);

        Date dataAtual = new Date();

        lixeiraParaColeta.setDataSolicitacao(dataAtual);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAtual);
        calendar.add(Calendar.DATE, 3);
        Date dataLimite = calendar.getTime();

        lixeiraParaColeta.setDataLimite(dataLimite);

        LixeiraParaColeta lixeiraParaColetaSalva = lixeiraParaColetaRepository.save(lixeiraParaColeta);

        return new DIsplayLixeiraParaColetaDTO(lixeiraParaColetaSalva);
    }

    private Lixeira getLixeiraById(Long id)
    {
        Optional<Lixeira> lixeira = lixeiraRepository.findById(id);

        if (lixeira.isEmpty())
        {
            String message = "A lixeira " + id + " não existe";

            throw new RuntimeException(message);
        }

        return lixeira.get();
    }

    public void deleteLixeiraParaColeta(Long id)
    {
        DIsplayLixeiraParaColetaDTO lixeiraParaColetaDTO = this.getLixeiraParaColetaById(id);
        LixeiraParaColeta lixeiraParaColeta = new LixeiraParaColeta();

        BeanUtils.copyProperties(lixeiraParaColetaDTO, lixeiraParaColeta);

        lixeiraParaColetaRepository.delete(lixeiraParaColeta);
    }

    public DIsplayLixeiraParaColetaDTO updateLixeiraParaColeta(UpdateLixeiraParaColetaDTO UpdateLixeiraParaColetaDTO)
    {
        DIsplayLixeiraParaColetaDTO lixeiraParaColetaDTO = this.getLixeiraParaColetaById(UpdateLixeiraParaColetaDTO.idLixeiraParaColeta());
        LixeiraParaColeta lixeiraParaColeta = new LixeiraParaColeta();

        BeanUtils.copyProperties(lixeiraParaColetaDTO, lixeiraParaColeta);

        lixeiraParaColeta.setAtivo(UpdateLixeiraParaColetaDTO.ativo());

        LixeiraParaColeta lixeiraParaColetaSalva = lixeiraParaColetaRepository.save(lixeiraParaColeta);

        return new DIsplayLixeiraParaColetaDTO(lixeiraParaColetaSalva);
    }
}
