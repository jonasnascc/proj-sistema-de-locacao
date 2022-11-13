package io.github.jonashnascimento.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Integer parcelaReferencia;

    @ManyToOne
    @JoinColumn(name="contrato_id")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name="emissor_id")
    private Locatario emissor;


    @Column(name = "pagamento_efetuado")
    private boolean pagamentoEfetuado;

    public Fatura(){}

    public Fatura(BigDecimal valor, Date data, Integer parcelaReferencia) {
        this.valor = valor;
        this.data = data;
        this.parcelaReferencia = parcelaReferencia;
    }

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

    public Integer getParcelaReferencia() {
        return parcelaReferencia;
    }

    public void setParcelaReferencia(Integer parcelaReferencia) {
        this.parcelaReferencia = parcelaReferencia;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Locatario getEmissor() {
        return emissor;
    }

    public void setEmissor(Locatario emissor) {
        this.emissor = emissor;
    }

    public boolean isPagamentoEfetuado() {
        return pagamentoEfetuado;
    }

    public void setPagamentoEfetuado(boolean pagamentoEfetuado) {
        this.pagamentoEfetuado = pagamentoEfetuado;
    }
}
