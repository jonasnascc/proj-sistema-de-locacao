package io.github.jonasnascimento.model;

import javax.persistence.*;

@Entity
@Table(name="objeto")
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(length = 250)
    private String caracteristicas;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="tipo")
    private Tipo tipo;

    @OneToOne
    @JoinColumn(name = "dono_id")
    private Locatario dono;

    @OneToOne
    @JoinColumn(name="locador_id")
    private Locador locador;

    @Column(name="locado")
    private boolean locado_flag;

    public Objeto(){}

    public Objeto(Tipo tipo, String nome){
        this.tipo = tipo;
        this.nome = nome;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String descricao) {
        this.caracteristicas = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Locatario getDono() {
        return dono;
    }

    public void setDono(Locatario dono) {
        this.dono = dono;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public boolean isLocado_flag() {
        return locado_flag;
    }

    public void setLocado_flag(boolean locado_flag) {
        this.locado_flag = locado_flag;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", tipo=" + tipo +
                ", dono=" + dono +
                ", locador=" + locador +
                ", locado_flag=" + locado_flag +
                '}';
    }
}
