package io.github.jonashnascimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoObjeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false, length = 40)
    private String nome;

    @ManyToOne
    private Usuario criador;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private List<Objeto> objetos;

}
