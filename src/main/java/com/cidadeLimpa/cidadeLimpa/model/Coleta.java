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
@Table(name = "tb_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coleta {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "SEQ_COLETA"
    )
    @SequenceGenerator(
        name = "SEQ_COLETA",
        sequenceName = "SEQ_COLETA",
        allocationSize = 50
    )
    @Column(name = "id_coleta")
    private Long idColeta;

    @ManyToOne
    private Caminhao caminhao;

    @ManyToOne
    private Lixeira lixeira;

    @Column(name = "data_coleta", nullable = false, length = 10)
    private String data;
}
