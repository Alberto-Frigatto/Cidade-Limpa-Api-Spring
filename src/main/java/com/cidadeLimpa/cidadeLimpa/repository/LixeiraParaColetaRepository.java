package com.cidadeLimpa.cidadeLimpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidadeLimpa.cidadeLimpa.model.LixeiraParaColeta;

public interface LixeiraParaColetaRepository extends JpaRepository<LixeiraParaColeta, Long>  {
    List<LixeiraParaColeta> findByAtivo(boolean ativo);

    @Query("SELECT l FROM LixeiraParaColeta l WHERE l.lixeira.idLixeira = :idLixeira")
    List<LixeiraParaColeta> findByIdLixeira(@Param("idLixeira") Long idLixeira);
}
