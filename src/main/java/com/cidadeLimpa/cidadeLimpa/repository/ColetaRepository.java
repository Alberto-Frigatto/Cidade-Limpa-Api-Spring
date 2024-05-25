package com.cidadeLimpa.cidadeLimpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidadeLimpa.cidadeLimpa.model.Coleta;

public interface ColetaRepository extends JpaRepository<Coleta, Long>
{
    @Query("SELECT c FROM Coleta c WHERE c.caminhao.idCaminhao = :idCaminhao")
    List<Coleta> findByIdCaminhao(@Param("idCaminhao") Long idCaminhao);

    @Query("SELECT c FROM Coleta c WHERE c.lixeira.idLixeira = :idLixeira")
    List<Coleta> findByIdLixeira(@Param("idLixeira") Long idLixeira);

    List<Coleta> findByData(@Param("data") String data);
}

