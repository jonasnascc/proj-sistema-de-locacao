package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    @NotNull(message = "{campo.num-pagamentos.obrigatorio}")
    @Length(min = 1, message = "{campo.num-pagamentos.valor-minimo}")
    private Integer numPagamentos;

    @NotNull(message = "{campo.valor-pagamentos.obrigatorio}")
    private BigDecimal valorPagamentos;

    @NotNull(message = "{campo.intervalo-dias.obrigatorio}")
    @Length(min = 1, message = "{campo.intervalo-dias.valor-minimo}")
    private Integer intervaloDias;

    private List<PagamentoDTO> pagamentos;
}
