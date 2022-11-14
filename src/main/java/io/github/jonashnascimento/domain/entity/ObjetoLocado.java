package io.github.jonashnascimento.domain.entity;

import io.github.jonashnascimento.domain.entity.Locador;

import javax.persistence.*;

@Entity
@Table
public class ObjetoLocado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "locador")
    private Locador locador;

    @OneToOne
    @JoinColumn(name = "objeto")
    private Objeto objeto;

    public ObjetoLocado(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
