package io.github.jonashnascimento.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    private Integer numPagamentos;
    private BigDecimal valorPagamentos;
    private Integer intervaloDias;
    private List<PagamentoDTO> pagamentos;
}
