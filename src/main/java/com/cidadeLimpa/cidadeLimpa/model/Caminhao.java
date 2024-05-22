package com.cidadeLimpa.cidadeLimpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_caminhao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao
{
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_CAMINHAO"
    )
    @SequenceGenerator(
        name = "SEQ_ROTA",
        sequenceName = "SEQ_ROTA",
        allocationSize = 50
    )
    @Column(name = "id_caminhao")
    private Long idCaminhao;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false, length = 7)
    private String placa;

    @ManyToOne
    private Rota rota;
}
