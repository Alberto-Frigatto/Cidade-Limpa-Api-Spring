package com.cidadeLimpa.cidadeLimpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidadeLimpa.cidadeLimpa.model.Caminhao;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    @Query("SELECT c FROM Caminhao c WHERE LOWER(c.modelo) LIKE LOWER(:modelo)")
    List<Caminhao> findByModelo(@Param("modelo") String modelo);

    @Query("SELECT c FROM Caminhao c WHERE c.capacidade BETWEEN :minCapacidade AND :maxCapacidade")
    List<Caminhao> findByCapacidade(@Param("minCapacidade") Integer minCapacidade, @Param("maxCapacidade") Integer maxCapacidade);

    List<Caminhao> findByPlaca(String placa);

    @Query("SELECT c FROM Caminhao c WHERE c.rota.idRota = :idRota")
    List<Caminhao> findByIdRota(@Param("idRota") Long idRota);
}
