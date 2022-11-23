package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class PagamentoDTO {
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.parcela-referencia.obrigatorio}")
    @Size(min = 1, message = "{campo.parcela-referencia.valor-minimo}")
    private Integer parcelaReferencia;

    @NotEmpty(message = "{campo.status.obrigatorio}")
    private String status;
}
