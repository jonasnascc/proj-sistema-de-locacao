package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoDTO {
    @NotEmpty(message = "O campo dono é obrigatório.")
    private Integer dono;

    @NotEmpty(message = "O campo descricao é obrigatório.")
    @Length(max = 60, message = "O campo descricao deve ter no máximo 60 caracteres.")
    private String descricao;

    @NotEmpty(message = "O campo caracteristicas é obrigatório.")
    @Length(max = 130, message = "O campo caracteristicas deve ter no márximo 130 caracteres.")
    private String caracteristicas;

    @NotEmpty(message = "O campo tipo deve ser obrigatório.")
    private String tipo;
}
