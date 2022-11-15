package io.github.jonashnascimento.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Integer parcelaReferencia;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contrato contrato;

    @Column(name = "pagamento_efetuado")
    private boolean pagamentoEfetuado;
}
