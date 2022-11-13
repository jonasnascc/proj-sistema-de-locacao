package io.github.jonashnascimento.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Locador extends Usuario{

    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Objeto> objetosAlugados;

    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Contrato> contratos;

    public Locador() {
    }

    public Locador(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public List<Objeto> getObjetosAlugados() {
        return objetosAlugados;
    }

    public void setObjetosAlugados(List<Objeto> objetosAlugados) {
        this.objetosAlugados = objetosAlugados;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}
