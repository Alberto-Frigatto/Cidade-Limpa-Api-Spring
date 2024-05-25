package com.cidadeLimpa.cidadeLimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cidadeLimpa.cidadeLimpa.dto.CreateCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.dto.DisplayCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.dto.UpdateCaminhaoDTO;
import com.cidadeLimpa.cidadeLimpa.exception.CaminhaoNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.RotaNotFound;
import com.cidadeLimpa.cidadeLimpa.model.Caminhao;
import com.cidadeLimpa.cidadeLimpa.model.Rota;
import com.cidadeLimpa.cidadeLimpa.repository.CaminhaoRepository;
import com.cidadeLimpa.cidadeLimpa.repository.RotaRepository;

@Service
public class CaminhaoService
{
    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private RotaRepository rotaRepository;

    public Page<DisplayCaminhaoDTO> getAllCaminhoes(Pageable pagination)
    {
        return caminhaoRepository
                    .findAll(pagination)
                    .map(caminhao -> new DisplayCaminhaoDTO(caminhao));
    }

    public DisplayCaminhaoDTO getCaminhaoById(Long id)
    {
        Optional<Caminhao> caminhao = caminhaoRepository.findById(id);

        if (caminhao.isEmpty())
            throw new CaminhaoNotFound(id);

        return new DisplayCaminhaoDTO(caminhao.get());
    }

    public DisplayCaminhaoDTO createCaminhao(CreateCaminhaoDTO createCaminhaoDTO)
    {
        Caminhao caminhao = new Caminhao();

        Rota rota = this.getRotaById(createCaminhaoDTO.idRota());

        caminhao.setRota(rota);
        caminhao.setCapacidade(createCaminhaoDTO.capacidade());
        caminhao.setModelo(createCaminhaoDTO.modelo());
        caminhao.setPlaca(createCaminhaoDTO.placa());

        Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);

        return new DisplayCaminhaoDTO(caminhaoSalvo);

    }

    private Rota getRotaById(Long id)
    {
        Optional<Rota> rota = rotaRepository.findById(id);

        if (rota.isEmpty())
            throw new RotaNotFound(id);

        return rota.get();
    }

    public void deleteCaminhao(Long id)
    {
        DisplayCaminhaoDTO caminhaoDTO = this.getCaminhaoById(id);
        Caminhao caminhao = new Caminhao();

        BeanUtils.copyProperties(caminhaoDTO, caminhao);

        caminhaoRepository.delete(caminhao);
    }

    public DisplayCaminhaoDTO updateCaminhao(UpdateCaminhaoDTO updateCaminhaoDTO)
    {
        Caminhao caminhao = new Caminhao();

        Rota rota = this.getRotaById(updateCaminhaoDTO.idRota());

        caminhao.setRota(rota);
        caminhao.setCapacidade(updateCaminhaoDTO.capacidade());
        caminhao.setModelo(updateCaminhaoDTO.modelo());
        caminhao.setPlaca(updateCaminhaoDTO.placa());

        Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);

        return new DisplayCaminhaoDTO(caminhaoSalvo);
    }

    public List<DisplayCaminhaoDTO> searchCaminhaoByModelo(String modelo)
    {
        return caminhaoRepository
                    .findByModelo("%" + modelo + "%")
                    .stream()
                    .map(DisplayCaminhaoDTO::new)
                    .toList();
    }

    public List<DisplayCaminhaoDTO> searchCaminhaoByCapacidade(Integer minCapacidade, Integer maxCapacidade)
    {
        return caminhaoRepository
                    .findByCapacidade(minCapacidade, maxCapacidade)
                    .stream()
                    .map(DisplayCaminhaoDTO::new)
                    .toList();
    }

    public List<DisplayCaminhaoDTO> searchCaminhaoByIdRota(Long idRota)
    {
        return caminhaoRepository
                    .findByIdRota(idRota)
                    .stream()
                    .map(DisplayCaminhaoDTO::new)
                    .toList();
    }

    public List<DisplayCaminhaoDTO> searchCaminhaoByPlaca(String placa)
    {
        return caminhaoRepository
                    .findByPlaca(placa)
                    .stream()
                    .map(DisplayCaminhaoDTO::new)
                    .toList();
    }
}
