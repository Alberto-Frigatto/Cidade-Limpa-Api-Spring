package com.cidadeLimpa.cidadeLimpa.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_rota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rota
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROTA"
    )
    @SequenceGenerator(
            name = "SEQ_ROTA",
            sequenceName = "SEQ_ROTA",
            allocationSize = 50
    )
    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "horario_inicio", nullable = false, length = 5)
    private String horarioInicio;

    @Column(name = "horario_fim", nullable = false, length = 5)
    private String horarioFim;

    @Column(name = "lista_pontos_coleta", nullable = false)
    private ArrayList<String> listaPontosColeta;
}
