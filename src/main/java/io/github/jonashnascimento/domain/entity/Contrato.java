package io.github.jonashnascimento.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer numPagamentos;

    @Column
    private BigDecimal valorPagamentos;

    @Column
    private Integer intervaloDias;

    @OneToOne(mappedBy = "contrato")
    private Locacao locacao;

    @OneToMany(mappedBy = "contrato")
    private List<Pagamento> pagamentos;

}
