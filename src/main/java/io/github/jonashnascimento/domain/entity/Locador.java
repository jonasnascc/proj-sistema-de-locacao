package io.github.jonashnascimento.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Locador extends Usuario{
    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<ObjetoLocado> objetosLocados;

    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Contrato> contratos;

    public Locador() {
    }

    public Locador(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }


    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}
