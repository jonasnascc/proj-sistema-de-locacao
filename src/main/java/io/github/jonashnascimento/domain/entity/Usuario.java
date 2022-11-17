package io.github.jonashnascimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 13)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "dono")
    private List<Objeto> objetosProprios;

    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Locacao> locacoesLocador;

    @JsonIgnore
    @OneToMany(mappedBy = "locatario")
    private List<Locacao> locacoesLocatario;

}
