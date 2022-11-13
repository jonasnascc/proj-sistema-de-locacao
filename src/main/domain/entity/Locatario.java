package io.github.jonashnascimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Locatario extends Usuario{
    @JsonIgnore
    @OneToMany(mappedBy = "dono")
    private List<Objeto> objetosProprios;

    @JsonIgnore
    @OneToMany(mappedBy = "locatario")
    private List<Contrato> contratos;

    @JsonIgnore
    @OneToMany(mappedBy = "emissor")
    private List<Fatura> faturasEmitidas;

    public Locatario() {
    }

    public Locatario(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public List<Objeto> getObjetosProprios() {
        return objetosProprios;
    }

    public void setObjetosProprios(List<Objeto> objetosProprios) {
        this.objetosProprios = objetosProprios;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<Fatura> getFaturasEmitidas() {
        return faturasEmitidas;
    }

    public void setFaturasEmitidas(List<Fatura> faturasEmitidas) {
        this.faturasEmitidas = faturasEmitidas;
    }
}
