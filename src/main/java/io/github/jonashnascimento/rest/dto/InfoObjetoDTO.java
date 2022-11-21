package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InfoObjetoDTO {
    private Integer codigo;
    private String descricao;
    private String tipo;
    private String caracteristicas;
    private String dono;
    private Integer donoId;
    private String status;
}
