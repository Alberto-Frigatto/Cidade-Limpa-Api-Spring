package com.cidadeLimpa.cidadeLimpa.model;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "tb_lixeira_a_ser_coletada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LixeiraParaColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIXEIRA_A_SER_COLETADA")
    @SequenceGenerator(name = "SEQ_LIXEIRA_A_SER_COLETADA", sequenceName = "SEQ_LIXEIRA_A_SER_COLETADA", allocationSize = 50)
    @Column(name = "id_lixeira_a_ser_coletada")
    private Long idLixeiraASerColetada;

    @Column(name = "data_solicitacao", nullable = false)
    private Date dataSolicitacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_limite", nullable = false)
    private Date dataLimite;

    @Column(nullable = false)
    private Boolean ativo;
}
