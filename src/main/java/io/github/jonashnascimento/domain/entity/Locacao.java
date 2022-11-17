package io.github.jonashnascimento.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "locador")
    private Usuario locador;

    @ManyToOne
    @JoinColumn(name="locatario")
    private Usuario locatario;

    @OneToOne
    @JoinColumn(name = "objeto_id")
    private Objeto objeto;

    @OneToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;
}
