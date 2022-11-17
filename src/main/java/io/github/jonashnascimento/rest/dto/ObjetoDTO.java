package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.domain.enums.StatusObjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoDTO {
    private Integer dono;
    private String nome;
    private String caracteristicas;
    private TipoDTO tipo;
    private String status;
}
