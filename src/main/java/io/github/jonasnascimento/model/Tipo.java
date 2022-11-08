package io.github.jonasnascimento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Tipo {
    @Id
    @Column(length = 50)
    private String nome;

    @OneToMany
    @JoinColumn(name="objetos")
    private Set<Objeto> objetos;

    public Tipo(String nome) {
        this.nome = nome;
    }

    public Tipo() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(Set<Objeto> objetos) {
        this.objetos = objetos;
    }
}
