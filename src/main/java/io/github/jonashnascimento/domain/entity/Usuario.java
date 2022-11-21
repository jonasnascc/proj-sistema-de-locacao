package io.github.jonashnascimento.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotEmpty(message = "Campo nome é obrigatório.")
    @Length(max = 50, message = "O nome de usuário precisa ter no máximo 50 caracteres.")
    private String nome;

    @Column(unique = true)
    @NotEmpty(message = "Campo CPF é obrigatório.")
    @CPF(message = "Informe um CPF válido.")
    private String cpf;

    @Column(nullable = false, length = 13)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "dono")
    private List<Objeto> objetosProprios;

    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Locacao> locacoesLocador;

    @JsonIgnore
    @OneToMany(mappedBy = "locatario")
    private List<Locacao> locacoesLocatario;

}
