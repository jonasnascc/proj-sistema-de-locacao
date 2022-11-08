package io.github.jonasnascimento.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private BigDecimal valor;

    @Column
    private Date data;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name="locatario_id")
    private Locatario locatario;

    @ManyToOne
    @JoinColumn(name="locador_id")
    private Locador locador;


    @Column(name = "efetuado")
    private boolean efetuado_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public boolean isEfetuado_flag() {
        return efetuado_flag;
    }

    public void setEfetuado_flag(boolean efetuado_flag) {
        this.efetuado_flag = efetuado_flag;
    }
}
