package io.github.jonasnascimento.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locatario")
public class Locatario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50)
    protected String nome;

    @Column(nullable = false, length = 14)
    protected String cpf;

    @Column(nullable = false, length = 14)
    protected String telefone;

    @OneToMany(mappedBy = "dono")
    private Set<Objeto> objetos;

    @OneToMany(mappedBy = "locatario")
    private Set<Conta> contas_emitidas;

    public Locatario(){}

    public Locatario(String nome, String cpf, String telefone){
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

    public Set<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(Set<Objeto> objetos) {
        this.objetos = objetos;
    }

    public Set<Conta> getContas_emitidas() {
        return contas_emitidas;
    }

    public void setContas_emitidas(Set<Conta> contas_emitidas) {
        this.contas_emitidas = contas_emitidas;
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

}
