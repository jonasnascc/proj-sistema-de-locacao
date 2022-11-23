package io.github.jonashnascimento.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO {
    @NotNull(message = "{campo.contrato.obrigatorio}")
    private ContratoDTO contrato;

    @NotNull(message = "{campo.objeto.obrigatorio}")
    private Integer objeto;

    @NotNull(message = "{campo.locador.obrigatorio}")
    private Integer locador;

    @NotNull(message = "{campo.locatario.obrigatorio}")
    private Integer locatario;
}