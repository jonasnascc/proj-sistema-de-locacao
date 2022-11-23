package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoDTO {
    @NotNull(message = "{campo.dono.obrigatorio}")
    private Integer dono;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Size(max = 60, message = "{campo.descricao.tamanho-maximo}")
    private String descricao;

    @NotEmpty(message = "{campo.caracteristicas.obrigatorio}")
    @Size(max = 130, message = "{campo.caracteristicas.tamanho-maximo}")
    private String caracteristicas;

    @NotEmpty(message = "{campo.tipo.obrigatorio}")
    private String tipo;
}
