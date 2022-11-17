package io.github.jonashnascimento.domain.entity;

import io.github.jonashnascimento.domain.enums.StatusPagamento;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private BigDecimal valor;

    @Column
    private Date data;

    @Column(nullable = false)
    private Integer parcelaReferencia;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contrato contrato;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusPagamento status;
}
