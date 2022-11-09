package io.github.jonasnascimento.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locador")
public class Locador{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    protected String nome;

    @Column(nullable = false, length = 14)
    protected String cpf;

    @Column(nullable = false, length = 14)
    protected String telefone;

    @OneToMany(mappedBy = "locador")
    private List<Conta> contas;

    @OneToMany(mappedBy = "locador")
    private List<Objeto> objetosAlugados;

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
    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> dividas) {
        this.contas = dividas;
    }

    public List<Objeto> getObjetosAlugados() {
        return objetosAlugados;
    }

    public void setObjetosAlugados(List<Objeto> objetos_alugados) {
        this.objetosAlugados = objetos_alugados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Locador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", objetos_alugados=" + objetosAlugados +
                '}';
    }
}
