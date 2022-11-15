package io.github.jonashnascimento.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 13)
    private String telefone;

}
