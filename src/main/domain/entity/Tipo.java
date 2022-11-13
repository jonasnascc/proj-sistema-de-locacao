package io.github.jonashnascimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false, length = 40)
    private String nome;

    @ManyToOne
    private Locatario criador;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private List<Objeto> objetos;

    public Tipo(){}

    public Tipo(String nome, Locatario criador) {
        this.nome = nome;
        this.criador = criador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Locatario getCriador() {
        return criador;
    }

    public void setCriador(Locatario criador) {
        this.criador = criador;
    }
}
