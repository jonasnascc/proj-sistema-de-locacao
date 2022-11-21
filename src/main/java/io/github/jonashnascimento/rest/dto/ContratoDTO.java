package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    @NotNull
    @Length(min = 1)
    private Integer numPagamentos;

    private BigDecimal valorPagamentos;

    private Integer intervaloDias;

    @NotEmptyList(message = "Contrato deve possuir n pagamentos.")
    private List<PagamentoDTO> pagamentos;
}
