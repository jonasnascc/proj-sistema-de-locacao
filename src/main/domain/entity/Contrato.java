package io.github.jonashnascimento.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private Integer n_faturas;

    @Column(nullable = false, updatable = false)
    private BigDecimal valorFaturas;

    @Column(nullable = false, updatable = false)
    private Integer intervalo;

    @ManyToOne
    private Locatario locatario;

    @ManyToOne
    private Locador locador;

    @OneToMany(mappedBy = "contrato")
    private List<Fatura> faturas;

    public Contrato(){}

    public Contrato(Integer n_faturas, BigDecimal valorFaturas, Integer intervalo) {
        this.n_faturas = n_faturas;
        this.valorFaturas = valorFaturas;
        this.intervalo = intervalo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getN_faturas() {
        return n_faturas;
    }

    public void setN_faturas(Integer n_faturas) {
        this.n_faturas = n_faturas;
    }

    public BigDecimal getValorFaturas() {
        return valorFaturas;
    }

    public void setValorFaturas(BigDecimal valorFaturas) {
        this.valorFaturas = valorFaturas;
    }

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }
}
