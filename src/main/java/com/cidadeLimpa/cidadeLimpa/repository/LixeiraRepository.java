package com.cidadeLimpa.cidadeLimpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidadeLimpa.cidadeLimpa.model.Lixeira;

public interface LixeiraRepository extends JpaRepository<Lixeira, Long> {
    @Query("SELECT l FROM Lixeira l WHERE LOWER(l.localizacao) LIKE LOWER(:localizacao)")
    List<Lixeira> findByLocalizacao(@Param("localizacao") String localizacao);

    @Query("SELECT l FROM Lixeira l WHERE l.capacidade BETWEEN :minCapacidade AND :maxCapacidade")
    List<Lixeira> findByCapacidade(@Param("minCapacidade") Integer minCapacidade, @Param("maxCapacidade") Integer maxCapacidade);

    @Query("SELECT l FROM Lixeira l WHERE l.ocupacao BETWEEN :minOcupacao AND :maxOcupacao")
    List<Lixeira> findByOcupacao(@Param("minOcupacao") BigDecimal minOcupacao, @Param("maxOcupacao") BigDecimal maxOcupacao);
}
