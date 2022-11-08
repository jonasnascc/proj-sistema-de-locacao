package io.github.jonasnascimento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locador")
public class Locador extends Pessoa {
    @OneToMany(targetEntity = Conta.class)
    @JoinTable(name="locador_contas")
    private Set<Conta> contas;

    @OneToMany(targetEntity = Objeto.class)
    @JoinTable(name="locador_objetos_alugados")
    private Set<Conta> objetos_alugados;

    public Locador(){}

    public Locador(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> dividas) {
        this.contas = dividas;
    }

    public Set<Conta> getObjetos_alugados() {
        return objetos_alugados;
    }

    public void setObjetos_alugados(Set<Conta> objetos_alugados) {
        this.objetos_alugados = objetos_alugados;
    }
}
