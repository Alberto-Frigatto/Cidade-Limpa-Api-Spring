package com.cidadeLimpa.cidadeLimpa.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.dto.CreateColetaDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayColetaDTO;
import com.cidadeLimpa.cidadeLimpa.exception.CaminhaoNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.ColetaNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.LixeiraNotFound;
import com.cidadeLimpa.cidadeLimpa.model.Caminhao;
import com.cidadeLimpa.cidadeLimpa.model.Coleta;
import com.cidadeLimpa.cidadeLimpa.model.Lixeira;
import com.cidadeLimpa.cidadeLimpa.repository.CaminhaoRepository;
import com.cidadeLimpa.cidadeLimpa.repository.ColetaRepository;
import com.cidadeLimpa.cidadeLimpa.repository.LixeiraRepository;

@Service
public class ColetaService
{
    @Autowired
    private ColetaRepository coletaRepository;

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private LixeiraRepository lixeiraRepository;

    public Page<DisplayColetaDTO> getAllColetas(Pageable pagination)
    {
        return coletaRepository
                    .findAll(pagination)
                    .map(coleta -> new DisplayColetaDTO(coleta));
    }

    public DisplayColetaDTO getColetaById(Long id)
    {
        Optional<Coleta> coleta = coletaRepository.findById(id);

        if (coleta.isEmpty())
            throw new ColetaNotFound(id);

        return new DisplayColetaDTO(coleta.get());
    }

    public DisplayColetaDTO createColeta(CreateColetaDTO createColetaDTO)
    {
        Coleta coleta = new Coleta();

        Caminhao caminhao = this.getCaminhaoById(createColetaDTO.idCaminhao());

        Lixeira lixeira = this.getLixeiraById(createColetaDTO.idLixeira());

        LocalDate dataAtual = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = dataAtual.format(formatter);

        coleta.setCaminhao(caminhao);
        coleta.setLixeira(lixeira);
        coleta.setData(dataFormatada);

        Coleta coletaSalva = coletaRepository.save(coleta);

        return new DisplayColetaDTO(coletaSalva);
    }

    private Caminhao getCaminhaoById(Long id)
    {
        Optional<Caminhao> caminhao = caminhaoRepository.findById(id);

        if (caminhao.isEmpty())
            throw new CaminhaoNotFound(id);

        return caminhao.get();
    }

    private Lixeira getLixeiraById(Long id)
    {
        Optional<Lixeira> lixeira = lixeiraRepository.findById(id);

        if (lixeira.isEmpty())
            throw new LixeiraNotFound(id);

        return lixeira.get();
    }

    public void deleteColeta(Long id)
    {
        DisplayColetaDTO coletaDTO = this.getColetaById(id);
        Coleta coleta = new Coleta();

        BeanUtils.copyProperties(coletaDTO, coleta);

        coletaRepository.delete(coleta);
    }

    public List<DisplayColetaDTO> searchColetaByIdCaminhao(Long idCaminhao)
    {
        return coletaRepository
                    .findByIdCaminhao(idCaminhao)
                    .stream()
                    .map(DisplayColetaDTO::new)
                    .toList();
    }

    public List<DisplayColetaDTO> searchColetaByIdLixeira(Long idLixeira)
    {
        return coletaRepository
                    .findByIdLixeira(idLixeira)
                    .stream()
                    .map(DisplayColetaDTO::new)
                    .toList();
    }

    public List<DisplayColetaDTO> searchColetaByData(String data)
    {
        return coletaRepository
                    .findByData(data)
                    .stream()
                    .map(DisplayColetaDTO::new)
                    .toList();
    }
}
