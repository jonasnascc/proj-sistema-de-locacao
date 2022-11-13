package io.github.jonashnascimento.domain.entity;

import javax.persistence.*;

@Entity
@Table
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String nome;

    @ManyToOne
    private Tipo tipo;

    @Column(length = 170)
    private String caracteristicas;

    @ManyToOne
    private Locatario dono;

    @ManyToOne
    private Locador locador;

    @Column
    private boolean locadoFlag;

    public Objeto(){}

    public Objeto(String nome, Tipo tipo, Locatario dono) {
        this.nome = nome;
        this.tipo = tipo;
        this.dono = dono;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isLocadoFlag() {
        return locadoFlag;
    }

    public void setLocadoFlag(boolean locado) {
        this.locadoFlag = locado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Locatario getDono() {
        return dono;
    }

    public void setDono(Locatario dono) {
        this.dono = dono;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }
}
