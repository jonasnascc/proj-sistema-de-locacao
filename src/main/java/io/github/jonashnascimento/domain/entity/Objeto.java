package io.github.jonashnascimento.domain.entity;

import io.github.jonashnascimento.domain.enums.StatusObjeto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Locatario dono;

    @Column(nullable = false, length = 30)
    private String nome;

    @ManyToOne
    private Tipo tipo;

    @Column(length = 170)
    private String caracteristicas;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusObjeto status;

}
