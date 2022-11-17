package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InfoObjetoDTO {
    private Integer codigo;
    private String status;
    private String nome;
    private String tipo;
    private String caracteristicas;
}
