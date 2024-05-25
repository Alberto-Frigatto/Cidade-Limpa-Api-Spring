package com.cidadeLimpa.cidadeLimpa.model;

import java.math.BigDecimal;

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
@Table(name = "tb_lixeira")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Lixeira
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_LIXEIRA"
    )
    @SequenceGenerator(
            name = "SEQ_LIXEIRA",
            sequenceName = "SEQ_LIXEIRA",
            allocationSize = 1
    )
    @Column(name = "id_lixeira")
    private Long idLixeira;

    @Column(nullable = false, length = 100)
    private String localizacao;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal ocupacao;
}
