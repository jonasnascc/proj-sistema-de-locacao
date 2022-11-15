package io.github.jonashnascimento.rest.dto;

import io.github.jonashnascimento.domain.entity.Fatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    private Integer n_faturas;
    private BigDecimal valorFaturas;
    private Integer intervaloDias;
    private List<FaturaDTO> faturas;
}
